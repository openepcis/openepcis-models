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
package io.openepcis.model.rest;

import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

@Slf4j
public class ExceptionMapper {

  @ServerExceptionMapper
  public final RestResponse<ProblemResponseBody> mapException(final Exception exception) {
    log.error(exception.getMessage(), exception);
    final ProblemResponseBody responseBody = new ProblemResponseBody();
    responseBody.setTitle("Internal Server Error");
    responseBody.setType(exception.getClass().getSimpleName());
    responseBody.setStatus(500);
    responseBody.setDetail(exception.getMessage());
    return RestResponse.status(RestResponse.Status.INTERNAL_SERVER_ERROR, responseBody);
  }
}
