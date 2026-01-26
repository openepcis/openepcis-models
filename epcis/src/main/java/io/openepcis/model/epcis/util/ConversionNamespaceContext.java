/*
 * Copyright 2022-2025 benelog GmbH & Co. KG
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */
package io.openepcis.model.epcis.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Per-conversion namespace context that replaces the ThreadLocal-based
 * {@link DefaultJsonSchemaNamespaceURIResolver} for reactive pipelines where
 * thread switching occurs.
 *
 * <p>Create one instance per conversion operation and pass it through the
 * pipeline explicitly. This avoids ThreadLocal issues with reactive thread
 * switching (e.g., {@code runSubscriptionOn()}).
 *
 * <p>Thread-safe via ConcurrentHashMap for safe use across reactive pipelines.
 *
 * <p><strong>Storage format:</strong> prefix -> URI (allows multiple prefixes for same URI,
 * which is valid in XML). For backward compatibility with callers expecting URI -> prefix
 * format, use {@link #getAllNamespaces()}.
 */
public class ConversionNamespaceContext {

  /**
   * Attribute key for storing context in Jackson ObjectMapper attributes.
   */
  public static final String ATTR_KEY = ConversionNamespaceContext.class.getName();

  /**
   * Property key for storing context in JAXB Unmarshaller.
   * Used to pass namespace context to afterUnmarshal() callbacks.
   */
  public static final String UNMARSHALLER_PROPERTY_KEY = "io.openepcis.conversion.namespaceContext";

  /**
   * Property key for storing context in JAXB Marshaller.
   * Used to pass namespace context to beforeMarshal() callbacks for creating properly namespaced XML elements.
   */
  public static final String MARSHALLER_PROPERTY_KEY = "io.openepcis.conversion.namespaceContext";

  /**
   * ThreadLocal for passing namespace context during synchronous JAXB unmarshal operations.
   * This is used as a fallback when JAXB implementation (like EclipseLink) doesn't support
   * custom properties on the unmarshaller.
   *
   * <p>The ThreadLocal is only used during the blocking unmarshal operation and is cleared
   * immediately after, so it's safe even in reactive contexts.
   */
  private static final ThreadLocal<ConversionNamespaceContext> UNMARSHAL_CONTEXT = new ThreadLocal<>();

  private final Map<String, String> documentNamespaces = new ConcurrentHashMap<>();
  private final Map<String, String> eventNamespaces = new ConcurrentHashMap<>();

  /**
   * Creates a new empty namespace context.
   */
  public ConversionNamespaceContext() {
  }

  /**
   * Creates a new event-scoped namespace context that includes document namespaces
   * from a parent context. This is used during JSON-to-XML conversion to ensure
   * each event only gets its own namespaces plus the document-level ones.
   *
   * @param documentContext the context containing document-level namespaces
   * @return a new context with document namespaces copied
   */
  public static ConversionNamespaceContext createEventScoped(ConversionNamespaceContext documentContext) {
    ConversionNamespaceContext eventScoped = new ConversionNamespaceContext();
    if (documentContext != null) {
      // Copy document namespaces (stored as prefix -> URI internally)
      eventScoped.documentNamespaces.putAll(documentContext.documentNamespaces);
    }
    return eventScoped;
  }

  /**
   * Retrieves the ConversionNamespaceContext from a JsonGenerator's ObjectCodec.
   *
   * @param gen the JsonGenerator
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> fromGenerator(JsonGenerator gen) {
    if (gen == null || gen.getCodec() == null) {
      return Optional.empty();
    }
    if (gen.getCodec() instanceof ObjectMapper mapper) {
      Object attr = mapper.getSerializationConfig().getAttributes().getAttribute(ATTR_KEY);
      if (attr instanceof ConversionNamespaceContext ctx) {
        return Optional.of(ctx);
      }
    }
    return Optional.empty();
  }

  /**
   * Retrieves the ConversionNamespaceContext from a JsonParser's ObjectCodec.
   *
   * @param parser the JsonParser
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> fromParser(JsonParser parser) {
    if (parser == null || parser.getCodec() == null) {
      return Optional.empty();
    }
    if (parser.getCodec() instanceof ObjectMapper mapper) {
      Object attr = mapper.getDeserializationConfig().getAttributes().getAttribute(ATTR_KEY);
      if (attr instanceof ConversionNamespaceContext ctx) {
        return Optional.of(ctx);
      }
    }
    return Optional.empty();
  }

  /**
   * Retrieves the ConversionNamespaceContext from a SerializerProvider.
   *
   * @param provider the SerializerProvider
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> fromSerializerProvider(SerializerProvider provider) {
    if (provider == null) {
      return Optional.empty();
    }
    Object attr = provider.getAttribute(ATTR_KEY);
    if (attr instanceof ConversionNamespaceContext ctx) {
      return Optional.of(ctx);
    }
    return Optional.empty();
  }

  /**
   * Retrieves the ConversionNamespaceContext from a DeserializationContext.
   *
   * @param ctxt the DeserializationContext
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> fromDeserializationContext(DeserializationContext ctxt) {
    if (ctxt == null) {
      return Optional.empty();
    }
    Object attr = ctxt.getAttribute(ATTR_KEY);
    if (attr instanceof ConversionNamespaceContext ctx) {
      return Optional.of(ctx);
    }
    return Optional.empty();
  }

  /**
   * Sets the namespace context for the current unmarshal operation.
   * Call this before JAXB unmarshal and clear it after with {@link #clearUnmarshalContext()}.
   *
   * @param context the namespace context for this unmarshal operation
   */
  public static void setUnmarshalContext(ConversionNamespaceContext context) {
    UNMARSHAL_CONTEXT.set(context);
  }

  /**
   * Clears the namespace context after unmarshal operation completes.
   * Always call this in a finally block after unmarshal.
   */
  public static void clearUnmarshalContext() {
    UNMARSHAL_CONTEXT.remove();
  }

  /**
   * Gets the current unmarshal context from ThreadLocal.
   *
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> getUnmarshalContext() {
    return Optional.ofNullable(UNMARSHAL_CONTEXT.get());
  }

  /**
   * Retrieves the ConversionNamespaceContext from a JAXB Unmarshaller.
   * Falls back to ThreadLocal if the unmarshaller doesn't support custom properties
   * (e.g., EclipseLink JAXB).
   *
   * @param unmarshaller the JAXB Unmarshaller
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> fromUnmarshaller(jakarta.xml.bind.Unmarshaller unmarshaller) {
    // First try the ThreadLocal (works with all JAXB implementations)
    ConversionNamespaceContext threadLocalContext = UNMARSHAL_CONTEXT.get();
    if (threadLocalContext != null) {
      return Optional.of(threadLocalContext);
    }

    // Fall back to unmarshaller property (may not be supported by all implementations)
    if (unmarshaller == null) {
      return Optional.empty();
    }
    try {
      Object property = unmarshaller.getProperty(UNMARSHALLER_PROPERTY_KEY);
      if (property instanceof ConversionNamespaceContext ctx) {
        return Optional.of(ctx);
      }
    } catch (jakarta.xml.bind.PropertyException e) {
      // Property not set or not supported, return empty
    }
    return Optional.empty();
  }

  /**
   * Retrieves the ConversionNamespaceContext from a JAXB Marshaller.
   *
   * @param marshaller the JAXB Marshaller
   * @return the context if available, or empty Optional
   */
  public static Optional<ConversionNamespaceContext> fromMarshaller(jakarta.xml.bind.Marshaller marshaller) {
    if (marshaller == null) {
      return Optional.empty();
    }
    try {
      Object property = marshaller.getProperty(MARSHALLER_PROPERTY_KEY);
      if (property instanceof ConversionNamespaceContext ctx) {
        return Optional.of(ctx);
      }
    } catch (jakarta.xml.bind.PropertyException e) {
      // Property not set or not supported, return empty
    }
    return Optional.empty();
  }

  // ==================== Population Methods ====================

  /**
   * Adds a document-level namespace mapping.
   * Storage: prefix -> URI (allows multiple prefixes for same URI).
   *
   * @param namespaceURI the namespace URI
   * @param prefix the namespace prefix
   */
  public void populateDocumentNamespaces(final String namespaceURI, final String prefix) {
    if (isNonEmpty(namespaceURI) && isNonEmpty(prefix)) {
      // Store as prefix -> URI (allows multiple prefixes for same URI)
      documentNamespaces.putIfAbsent(prefix, namespaceURI);
    }
  }

  /**
   * Adds an event-level namespace mapping.
   * Storage: prefix -> URI (allows multiple prefixes for same URI).
   *
   * @param namespaceURI the namespace URI
   * @param prefix the namespace prefix
   */
  public void populateEventNamespaces(final String namespaceURI, final String prefix) {
    if (isNonEmpty(namespaceURI) && isNonEmpty(prefix)) {
      // Store as prefix -> URI (allows multiple prefixes for same URI)
      eventNamespaces.putIfAbsent(prefix, namespaceURI);
    }
  }

  // ==================== Reset Methods ====================

  /**
   * Clears all event-level namespaces.
   */
  public void resetEventNamespaces() {
    eventNamespaces.clear();
  }

  /**
   * Clears all document-level and event-level namespaces.
   */
  public void resetAllNamespaces() {
    documentNamespaces.clear();
    eventNamespaces.clear();
  }

  // ==================== Retrieval Methods ====================

  /**
   * Retrieves a copy of the document-level namespaces.
   * Returned in URI -> prefix format for backward compatibility.
   *
   * @return map of URI to prefix for document namespaces
   */
  public Map<String, String> getDocumentNamespaces() {
    // Convert from internal prefix -> URI to external URI -> prefix
    Map<String, String> uriToPrefix = new HashMap<>();
    for (Map.Entry<String, String> entry : documentNamespaces.entrySet()) {
      uriToPrefix.put(entry.getValue(), entry.getKey());
    }
    return uriToPrefix;
  }

  /**
   * Retrieves a copy of the event-level namespaces.
   * Returned in URI -> prefix format for backward compatibility.
   *
   * @return map of URI to prefix for event namespaces
   */
  public Map<String, String> getEventNamespaces() {
    // Convert from internal prefix -> URI to external URI -> prefix
    Map<String, String> uriToPrefix = new HashMap<>();
    for (Map.Entry<String, String> entry : eventNamespaces.entrySet()) {
      uriToPrefix.put(entry.getValue(), entry.getKey());
    }
    return uriToPrefix;
  }

  /**
   * Retrieves a combined copy of document-level and event-level namespaces.
   * Event namespaces override document namespaces if there are conflicts.
   * Returned in URI -> prefix format for backward compatibility with JAXB.
   *
   * <p>Note: When multiple prefixes map to the same URI, only one prefix is returned
   * per URI (the last one encountered). Use {@link #getNamespacesForXml()} to get
   * all prefixes.
   *
   * @return combined map of URI to prefix
   */
  public Map<String, String> getAllNamespaces() {
    // Convert from internal prefix -> URI to external URI -> prefix
    // Note: This may lose some prefixes if multiple prefixes map to the same URI
    final Map<String, String> uriToPrefix = new HashMap<>();
    for (Map.Entry<String, String> entry : documentNamespaces.entrySet()) {
      uriToPrefix.put(entry.getValue(), entry.getKey());
    }
    for (Map.Entry<String, String> entry : eventNamespaces.entrySet()) {
      uriToPrefix.put(entry.getValue(), entry.getKey());
    }
    return uriToPrefix;
  }

  // ==================== Lookup Methods ====================

  /**
   * Finds the namespace URI associated with a given prefix.
   * Searches both document and event namespaces.
   *
   * @param prefix the namespace prefix to look up
   * @return the namespace URI if found
   */
  public Optional<String> findNamespaceByPrefix(final String prefix) {
    // Direct lookup since internal storage is prefix -> URI
    String uri = eventNamespaces.get(prefix);
    if (uri != null) {
      return Optional.of(uri);
    }
    uri = documentNamespaces.get(prefix);
    return Optional.ofNullable(uri);
  }

  /**
   * Finds the prefix associated with a given namespace URI.
   * Searches both document and event namespaces.
   *
   * @param namespaceURI the namespace URI to look up
   * @return the prefix if found
   */
  public Optional<String> findPrefixByNamespace(final String namespaceURI) {
    // Search values since internal storage is prefix -> URI
    for (Map.Entry<String, String> entry : eventNamespaces.entrySet()) {
      if (entry.getValue().equals(namespaceURI)) {
        return Optional.of(entry.getKey());
      }
    }
    for (Map.Entry<String, String> entry : documentNamespaces.entrySet()) {
      if (entry.getValue().equals(namespaceURI)) {
        return Optional.of(entry.getKey());
      }
    }
    return Optional.empty();
  }

  // ==================== XML Output Methods ====================

  /**
   * Returns namespaces in prefix->URI format for XML namespace writing.
   * This preserves all prefixes, even when multiple prefixes map to the same URI.
   *
   * @return map of prefix to URI
   */
  public Map<String, String> getNamespacesForXml() {
    // Internal storage is already prefix -> URI, so return combined copy
    Map<String, String> prefixToUri = new HashMap<>();
    prefixToUri.putAll(documentNamespaces);
    prefixToUri.putAll(eventNamespaces);
    return prefixToUri;
  }

  // ==================== Helper Methods ====================

  private boolean isNonEmpty(final String value) {
    return StringUtils.isNotBlank(value);
  }
}
