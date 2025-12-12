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

import jakarta.xml.bind.Unmarshaller;

/**
 * JAXB Unmarshaller listener that injects {@link ConversionNamespaceContext}
 * into model objects that implement {@link NamespaceContextAware}.
 *
 * <p>This listener should be registered with the Unmarshaller before unmarshalling:
 * <pre>{@code
 * ConversionNamespaceContext nsContext = new ConversionNamespaceContext();
 * Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
 * unmarshaller.setListener(new NamespaceContextUnmarshallerListener(nsContext));
 * }</pre>
 *
 * <p>The context is injected in {@link #beforeUnmarshal(Object, Object)}, ensuring
 * it is available when the model's {@code afterUnmarshal} callback is invoked.
 */
public class NamespaceContextUnmarshallerListener extends Unmarshaller.Listener {

    private final ConversionNamespaceContext context;

    /**
     * Creates a new listener with the specified namespace context.
     *
     * @param context the namespace context to inject into model objects
     */
    public NamespaceContextUnmarshallerListener(ConversionNamespaceContext context) {
        this.context = context;
    }

    /**
     * Called before an object is unmarshalled. If the target implements
     * {@link NamespaceContextAware}, the namespace context is injected.
     *
     * @param target the object being unmarshalled
     * @param parent the parent object (may be null for root elements)
     */
    @Override
    public void beforeUnmarshal(Object target, Object parent) {
        if (target instanceof NamespaceContextAware aware) {
            aware.setNamespaceContext(context);
        }
    }
}
