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
package io.openepcis.model.rest.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.openepcis.model.rest.ProblemResponseBody;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.NotAcceptableException;
import jakarta.ws.rs.NotSupportedException;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

@Singleton
public class ServletSupport {

  @Inject Instance<ObjectMapper> objectMapper;

  @Inject Instance<Marshaller> marshaller;

  public void writeException(
      final WebApplicationException exception,
      final String mediaType,
      final HttpServletResponse resp)
      throws IOException {
    resp.setStatus(exception.getResponse().getStatus());
    if (!StringUtils.isEmpty(mediaType)
        && (mediaType.contains("json") || mediaType.equals(MediaType.WILDCARD))) {
      if (objectMapper.isUnsatisfied()) {
        throw new IOException("ObjectMapper unsatisfied injection dependency");
      }
      resp.setHeader(HttpHeaders.CONTENT_TYPE, "application/problem+json");
      objectMapper
          .get()
          .writeValue(resp.getOutputStream(), ProblemResponseBody.fromException(exception));
    } else {
      final StringWriter stringWriter = new StringWriter();
      try {
        if (marshaller.isUnsatisfied()) {
          throw new IOException("Marshaller unsatisfied injection dependency");
        }
        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_XML);
        marshaller
            .get()
            .marshal(ProblemResponseBody.fromException(exception), resp.getOutputStream());
      } catch (JAXBException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public Optional<String> accept(
      final List<String> produces, final HttpServletRequest req, final HttpServletResponse resp)
      throws IOException {
    final String accept =
        Optional.ofNullable(req.getHeader(HttpHeaders.ACCEPT)).orElse(produces.get(0));
    if (!produces.stream().anyMatch(accept::contains)) {
      writeException(
          new NotSupportedException("The accept header value did not match the value in @Produces"),
          accept,
          resp);
      return Optional.empty();
    }
    return Optional.of(accept);
  }

  public Optional<String> contentType(
      final List<String> consumes,
      final String accept,
      final HttpServletRequest req,
      final HttpServletResponse resp)
      throws IOException {
    final String contentType = req.getContentType();
    if (!StringUtils.isEmpty(contentType) && !consumes.stream().anyMatch(contentType::contains)) {
      writeException(
          new NotSupportedException(
              "The content-type header value did not match the value in @Consumes"),
          accept,
          resp);
      return Optional.empty();
    }
    return Optional.of(contentType);
  }

  public boolean accepted(
      final Optional<String> accept, final String media, final HttpServletResponse resp)
      throws IOException {
    if (accept.isEmpty()) {
      return false;
    }
    final boolean accepted =
        accept.get().contains(media) || accept.get().equals(MediaType.WILDCARD);
    if (!accepted) {
      writeException(
          new NotAcceptableException(
              "The accept header value did not match the value in @Produces"),
          accept.get(),
          resp);
    }
    return accepted;
  }

  public void writeJson(final HttpServletResponse resp, Object value) throws IOException {
    if (objectMapper.isUnsatisfied()) {
      throw new IOException("ObjectMapper unsatisfied injection dependency");
    }
    objectMapper.get().writeValue(resp.getOutputStream(), value);
  }
}
