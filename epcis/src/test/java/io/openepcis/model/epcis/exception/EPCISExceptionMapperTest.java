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
package io.openepcis.model.epcis.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.openepcis.model.rest.ProblemResponseBody;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * What a client is told when a request cannot be served. Three of these answers used to disagree
 * with the EPCIS 2.0 REST bindings, and two of them disagreed with their own response body.
 */
class EPCISExceptionMapperTest {

    private static final EPCISExceptionMapper MAPPER = new EPCISExceptionMapper();

    /** The status in the body and the status of the response are the same number or one of them lies. */
    private static void consistent(final RestResponse<ProblemResponseBody> response, final int expected) {
        assertEquals(expected, response.getStatus());
        assertEquals(expected, response.getEntity().getStatus());
    }

    @Test
    @DisplayName("a name already in use is a conflict, not a malformed request")
    void duplicateNameIsAConflict() {
        // Measured on a running repository on 2026-09-28: POST /queries with the name of an
        // existing query answered 400 epcisExceptions:DuplicateNameException, so a client could
        // not tell a taken name from a query it had built wrongly. The standard reserves 409 for
        // exactly this and names the type ResourceAlreadyExistsException.
        final RestResponse<ProblemResponseBody> response =
                MAPPER.mapException(new DuplicateNameException(ExceptionMessages.QUERY_NAME_ALREADY_EXIST));

        consistent(response, 409);
        assertEquals("epcisException:ResourceAlreadyExistsException", response.getEntity().getType());
    }

    @Test
    @DisplayName("a validation failure stays a 400 and keeps its own type")
    void validationStaysBadRequest() {
        final RestResponse<ProblemResponseBody> response =
                MAPPER.mapException(new QueryValidationException("missing query name"));

        consistent(response, 400);
        assertEquals("epcisException:QueryValidationException", response.getEntity().getType());
    }

    @Test
    @DisplayName("an unsupported media type answers 415, which is what its body already claimed")
    void unsupportedMediaTypeAnswers415() {
        final RestResponse<ProblemResponseBody> response =
                MAPPER.mapException(new UnsupportedMediaTypeException("text/plain"));

        consistent(response, 415);
    }

    @Test
    @DisplayName("a denied subscription answers 403, which is what its response already was")
    void subscriptionDeniedAnswers403() {
        final RestResponse<ProblemResponseBody> response =
                MAPPER.mapException(new SubscribeNotPermittedException("not permitted"));

        consistent(response, 403);
    }

    @Test
    @DisplayName("every problem type carries the prefix the standard writes, in the singular")
    void problemTypesUseTheStandardPrefix() {
        // EPCIS 2.0 writes epcisException: throughout; ours wrote epcisExceptions: everywhere,
        // in the one field a client is meant to branch on.
        assertTrue(
                MAPPER.mapException(new NoSuchNameException("gone")).getEntity().getType()
                        .startsWith("epcisException:"));
        assertEquals("epcisException:", ExceptionMessages.EPCIS_EXCEPTIONS);
    }
}
