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

import static io.openepcis.model.epcis.exception.ExceptionMessages.*;
import io.openepcis.model.rest.ProblemResponseBody;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class EPCISExceptionMapper {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(EPCISExceptionMapper.class);

  // Declared before its parent QueryValidationException so the more specific mapper wins.
  // A named query whose name is taken is not a malformed request: nothing about the body is
  // wrong, the name is simply in use. EPCIS 2.0 answers that with 409 and the problem type
  // ResourceAlreadyExistsException, and a client that means to replace a query needs to tell
  // 409 apart from the 400 it gets for a genuinely invalid one.
  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final DuplicateNameException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + "ResourceAlreadyExistsException");
    responseBody.title(RESOURCE_ALREADY_EXISTS);
    responseBody.setStatus(409);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.CONFLICT, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final QueryValidationException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(VALIDATION_FAILED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final QueryParameterException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(QUERY_PARAMS_NOT_AS_EXPECTED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final UnsupportedMediaTypeException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title("Unsupported Media Type");
    responseBody.setStatus(415);
    responseBody.setDetail(exception.getMessage());
    // Was BAD_REQUEST, which contradicted the 415 in the body of the very same response.
    return RestResponse.status(RestResponse.Status.UNSUPPORTED_MEDIA_TYPE, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final SubscribeNotPermittedException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(SUBSCRIPTION_DENIED);
    // The response is 403; the body said 400.
    responseBody.setStatus(403);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.FORBIDDEN, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final SubscriptionControlsException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(INVALID_SUBSCRIPTION_CONTROL);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final CaptureValidationException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(VALIDATION_FAILED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final NoSubscriptionFoundException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(NO_SUBSCRIPTION_FOUND);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final NoSuchEventTypeException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(INVALID_EVENT_TYPE);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final EPCISException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title("REST Exception");
    responseBody.setStatus(exception.getStatus());
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.fromStatusCode(exception.getStatus()), responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final QueryTooLargeException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(SEARCH_RESULT_SIZE_TOO_LARGE_NARROW_DOWN_THE_SEARCH_CRITERIA);
    responseBody.setStatus(exception.getStatus());
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.fromStatusCode(exception.getStatus()), responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final NoSuchNameException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(RESOURCE_NOT_FOUND);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final NoEventFoundException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(RESOURCE_NOT_FOUND);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final NotAcceptedException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(SERVER_CANT_RETURN_RESPONSE_AS_EXPECTED);
    responseBody.setStatus(406);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_ACCEPTABLE, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final CaptureLimitExceededException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(CAPTURE_PAYLOAD_TOO_LARGE);
    responseBody.setStatus(413);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.PAYLOAD_TOO_LARGE, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final UnsupportedQueryParameterException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(exception.getMessage());
    responseBody.setStatus(501);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_IMPLEMENTED, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final PersistenceException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(RestResponse.Status.INTERNAL_SERVER_ERROR.toString());
    responseBody.title(exception.getClass().getSimpleName());
    responseBody.setStatus(RestResponse.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.INTERNAL_SERVER_ERROR, responseBody);
  }
}
