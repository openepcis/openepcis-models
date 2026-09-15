/*
 * Copyright 2022-2026 benelog GmbH & Co. KG
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
package io.openepcis.model.epcis;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The {@code @context} a query result carries.
 *
 * <p>Every event repeats the namespaces it uses, so a result set of fifty
 * events that all extend with {@code acme} used to answer with fifty identical
 * {@code {"acme": "..."}} objects. Valid JSON-LD, and harmless to expand, but it
 * grows with the result set and says nothing the first one did not.
 *
 * <p>The awkward half is why they cannot simply be merged: two events may bind
 * the same prefix to different IRIs, and collapsing those would expand one of
 * them against the wrong IRI. So identical declarations collapse and
 * conflicting ones stay apart.
 */
class EPCISQueryDocumentContextTest {

    private static final String ACME = "https://ref.acme.com/voc/";

    private static ObjectEvent eventWith(final Map<String, Object> namespaces) {
        final ObjectEvent event = new ObjectEvent();
        event.setContextInfo(new ArrayList<>(List.of(new LinkedHashMap<>(namespaces))));
        return event;
    }

    private static List<Object> contextOf(final EPCISEvent... events) {
        final EPCISQueryDocument document = new EPCISQueryDocument(
                new EPCISQueryBody(EpcisQueryResult.builder()
                        .resultsBody(new QueryResultsBody(List.of(events)))
                        .build()),
                Optional.empty());
        return document.getContext();
    }

    @SuppressWarnings("unchecked")
    private static Map<String, Object> mapAt(final List<Object> context, final int index) {
        return assertInstanceOf(Map.class, context.get(index));
    }

    @Test
    @DisplayName("The same namespace in every event is declared once, not once per event")
    void identicalNamespacesCollapse() {
        final List<Object> context = contextOf(
                eventWith(Map.of("acme", ACME)),
                eventWith(Map.of("acme", ACME)),
                eventWith(Map.of("acme", ACME)));

        assertEquals(2, context.size(), "the EPCIS context plus ONE namespace object, not three; was " + context);
        assertInstanceOf(String.class, context.get(0));
        assertEquals(Map.of("acme", ACME), mapAt(context, 1));
    }

    @Test
    @DisplayName("Different prefixes from different events end up in one object")
    void differentPrefixesMerge() {
        final List<Object> context = contextOf(
                eventWith(Map.of("acme", ACME)),
                eventWith(Map.of("example", "https://example.test/voc/")));

        assertEquals(2, context.size(), "one namespace object holding both; was " + context);
        final Map<String, Object> namespaces = mapAt(context, 1);
        assertEquals(ACME, namespaces.get("acme"));
        assertEquals("https://example.test/voc/", namespaces.get("example"));
    }

    @Test
    @DisplayName("The same prefix bound to different IRIs stays two objects — the later one wins, as JSON-LD says")
    void conflictingPrefixesStayApart() {
        // Merging these would drop one binding and expand the events that used
        // it against the wrong IRI.
        final List<Object> context = contextOf(
                eventWith(Map.of("acme", ACME)),
                eventWith(Map.of("acme", "https://other.test/voc/")));

        assertEquals(3, context.size(), "both bindings must survive; was " + context);
        assertEquals(ACME, mapAt(context, 1).get("acme"));
        assertEquals("https://other.test/voc/", mapAt(context, 2).get("acme"),
                "the conflicting binding comes later, so it overrides");
    }

    @Test
    @DisplayName("A conflict does not tear apart the declarations that agree")
    void conflictKeepsTheAgreeingOnesTogether() {
        final List<Object> context = contextOf(
                eventWith(Map.of("acme", ACME, "shared", "https://shared.test/voc/")),
                eventWith(Map.of("acme", "https://other.test/voc/", "shared", "https://shared.test/voc/")));

        assertEquals(3, context.size(), "was " + context);
        final Map<String, Object> merged = mapAt(context, 1);
        assertEquals(ACME, merged.get("acme"));
        assertEquals("https://shared.test/voc/", merged.get("shared"));
        assertEquals(Map.of("acme", "https://other.test/voc/"), mapAt(context, 2),
                "only the conflicting prefix is repeated");
    }

    @Test
    @DisplayName("Events without namespaces answer with the EPCIS context alone")
    void noNamespacesNoObject() {
        final List<Object> context = contextOf(new ObjectEvent(), new ObjectEvent());
        assertEquals(1, context.size(), "was " + context);
        assertTrue(context.get(0) instanceof String);
    }
}
