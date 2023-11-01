/*
 * Copyright 2022-2023 benelog GmbH & Co. KG
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

import io.openepcis.model.rest.ProblemResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import static io.openepcis.model.epcis.exception.ExceptionMessages.*;

@Slf4j
public class EPCISExceptionMapper {

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final QueryValidationException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(VALIDATION_FAILED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final QueryParameterException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(QUERY_PARAMS_NOT_AS_EXPECTED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final UnsupportedMediaTypeException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title("Unsupported Media Type");
    responseBody.setStatus(415);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final SubscribeNotPermittedException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(SUBSCRIPTION_DENIED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.FORBIDDEN, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final SubscriptionControlsException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(INVALID_SUBSCRIPTION_CONTROL);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final CaptureValidationException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(VALIDATION_FAILED);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final NoSubscriptionFoundException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(NO_SUBSCRIPTION_FOUND);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final NoSuchEventTypeException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(INVALID_EVENT_TYPE);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
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
  public final RestResponse<ProblemResponseBody> mapException(
      final NoEventFoundException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(RESOURCE_NOT_FOUND);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final NotAcceptedException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(SERVER_CANT_RETURN_RESPONSE_AS_EXPECTED);
    responseBody.setStatus(406);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_ACCEPTABLE, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final CaptureLimitExceededException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(CAPTURE_PAYLOAD_TOO_LARGE);
    responseBody.setStatus(413);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.PAYLOAD_TOO_LARGE, responseBody);
  }

}
