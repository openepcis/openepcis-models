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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * A named query is a question: a name and the query that asks it. The version of the documents a
 * subscriber receives is a property of the subscription that delivers them, so it has no place
 * here. These hold that line, because the field used to be filled from the request header of
 * whichever client created the query and then decided what every subscriber of it received.
 */
class NamedQueryMetaDataTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Test
    @DisplayName("a named query is a name and a query, and says nothing about versions")
    void aNamedQueryCarriesNoVersion() throws Exception {
        final NamedQueryMetaData query =
                NamedQueryMetaData.builder()
                        .name("factory-sold")
                        .epcisQuery(Map.of("EQ_bizStep", List.of("retail_selling")))
                        .build();

        final JsonNode json = MAPPER.valueToTree(query);

        assertEquals("factory-sold", json.path("name").asText());
        assertTrue(json.has("query"));
        assertFalse(json.has("epcisVersion"), "a query does not decide what its subscribers receive");
    }

    @Test
    @DisplayName("a version sent along with a query is not kept")
    void aVersionInTheRequestIsNotKept() throws Exception {
        // a client may still send one, out of habit or from an older tool; it is read as nothing
        final NamedQueryMetaData query =
                MAPPER.readValue(
                        """
                        {"name":"factory-sold","query":{"EQ_bizStep":["retail_selling"]},"epcisVersion":"2.0.1"}""",
                        NamedQueryMetaData.class);

        assertEquals("factory-sold", query.getName());
        assertFalse(MAPPER.valueToTree(query).has("epcisVersion"));
    }
}
