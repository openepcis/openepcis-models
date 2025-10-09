/*
 * Copyright 2022-2024 benelog GmbH & Co. KG
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
package io.openepcis.model.rest.exception;

import static io.openepcis.model.rest.exception.RESTExceptionMessages.*;

import io.openepcis.core.exception.*;
import io.openepcis.core.exception.SecurityException;
import io.openepcis.model.rest.ProblemResponseBody;
import io.smallrye.mutiny.CompositeException;
import jakarta.ws.rs.WebApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;


import static io.openepcis.model.rest.exception.RESTExceptionMessages.*;
@Slf4j
public class RESTExceptionMapper {

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final Exception exception) {
    Throwable ex = exception;
    if (CompositeException.class.isAssignableFrom(exception.getClass())) {
      ex = exception.getCause();
    }
    log.error(ex.getMessage(), exception);
    return createResponse(ex, RestResponse.Status.INTERNAL_SERVER_ERROR);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final WebApplicationException exception) {
    log.debug(exception.getMessage(), exception);
    final ProblemResponseBody responseBody = ProblemResponseBody.fromException(exception);
    return RestResponse.status(exception.getResponse().getStatusInfo(), responseBody);
  }

  public static RestResponse<ProblemResponseBody> createResponse(
      final Throwable exception, RestResponse.Status status) {
    final ProblemResponseBody responseBody = ProblemResponseBody.fromException(exception, status);
    return RestResponse.status(status, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final InvalidURIException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(INVALID_URI);
    responseBody.setStatus(400);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.BAD_REQUEST, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final SecurityException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(ACCESS_DENIED);
    responseBody.setStatus(401);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.UNAUTHORIZED, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final ResourceNotFoundException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(RESOURCE_DOES_NOT_EXIST);
    responseBody.setStatus(404);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_FOUND, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final ImplementationException exception) {
    log.info(exception.getMessage());
    log.error(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(SERVER_SIDE_ERROR_OCCURRED);
    responseBody.setStatus(500);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.INTERNAL_SERVER_ERROR, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final MarshallingException exception) {
    log.info(exception.getMessage());
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(EPCIS_EXCEPTIONS + exception.getClass().getSimpleName());
    responseBody.title(ERROR_IN_DATA_FORMAT);
    responseBody.setStatus(406);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.NOT_ACCEPTABLE, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final SchemaValidationException exception) {
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
      final java.lang.SecurityException exception) {
    log.error(exception.getMessage(), exception);
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(exception.getClass().getSimpleName());
    responseBody.title(ACCESS_DENIED);
    responseBody.setStatus(401);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.UNAUTHORIZED, responseBody);
  }

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(
      final ResourceAlreadyExistsException exception) {
    log.error(exception.getMessage(), exception);
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setType(exception.getClass().getSimpleName());
    responseBody.title(RESOURCE_ALREADY_EXISTS);
    responseBody.setStatus(409);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.CONFLICT, responseBody);
  }

}
