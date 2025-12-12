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

/**
 * Interface for model classes that need access to a {@link ConversionNamespaceContext}
 * during JAXB unmarshalling operations.
 *
 * <p>Model classes implementing this interface will have their namespace context
 * injected by {@link NamespaceContextUnmarshallerListener} before the
 * {@code afterUnmarshal} callback is invoked.
 *
 * <p>This enables per-conversion namespace context passing without relying on
 * ThreadLocal, making the code safe for reactive pipelines where thread switching
 * occurs.
 */
public interface NamespaceContextAware {

    /**
     * Sets the namespace context for this model instance.
     *
     * @param context the namespace context to use, may be null
     */
    void setNamespaceContext(ConversionNamespaceContext context);

    /**
     * Gets the namespace context for this model instance.
     *
     * @return the namespace context, or null if not set
     */
    ConversionNamespaceContext getNamespaceContext();
}
