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
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.model.dto.QuerySubscription;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * The signatureToken is the subscriber's own secret: it hands it over once so the repository can
 * sign the events it pushes back, and it is how the subscriber tells our callbacks from anybody
 * else's. EPCIS 2.0 keeps it out of every response, and its subscription response schema has no
 * such member at all. Measured on a running repository on 2026-09-28, a GET on a subscription
 * returned the token in full, and so did the list of a query's subscriptions, so anybody who could
 * read a subscription could forge its callbacks.
 *
 * <p>This class is also the store's read model, so the token has to survive being read back in.
 * Both directions are held here, because a fix that silenced the response by dropping the field
 * would have left the delivery unable to sign.
 */
class QuerySubscriptionSecretTest {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    // Deliberately not a plausible token: a realistic one here trips secret scanning, and the
    // point of the fixture is only that whatever is read in does not come back out.
    private static final String STORED =
            """
            {"subscriptionID":"af176948-083f-4cd1-b0dc-f72b2ece0a43",
             "queryName":"factory-ore-mined",
             "dest":"https://client.example.com/queryCallback",
             "signatureToken":"THIS-IS-NOT-A-SECRET-it-stands-in-for-a-subscriber-token",
             "stream":true}
            """;

    @Test
    @DisplayName("the token is read from the store")
    void tokenIsReadIn() throws Exception {
        final QuerySubscription subscription = MAPPER.readValue(STORED, QuerySubscription.class);
        assertEquals(
                "THIS-IS-NOT-A-SECRET-it-stands-in-for-a-subscriber-token",
                subscription.getSignatureToken());
    }

    @Test
    @DisplayName("and never written back out to a client")
    void tokenIsNotWrittenOut() throws Exception {
        final QuerySubscription subscription = MAPPER.readValue(STORED, QuerySubscription.class);
        final String json = MAPPER.writeValueAsString(subscription);

        assertFalse(json.contains("signatureToken"), json);
        assertFalse(json.contains("THIS-IS-NOT-A-SECRET-it-stands-in-for-a-subscriber-token"), json);
        // what a subscriber does need to see is still there
        assertNotNull(MAPPER.readTree(json).get("subscriptionID"));
        assertNotNull(MAPPER.readTree(json).get("dest"));
    }
}
