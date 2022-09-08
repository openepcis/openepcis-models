/*
 * Copyright 2022 benelog GmbH & Co. KG
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

import java.util.Objects;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EPCISDocument {

  private EPCISBody epcisBody;
  private String errorUrl;
  private EPCISHeader epcisHeader;

  public boolean hasEvents() {
    return Objects.nonNull(epcisBody)
        && Objects.nonNull(epcisBody.getEventList())
        && !epcisBody.getEventList().isEmpty();
  }

  public boolean hasEvent() {
    return Objects.nonNull(epcisBody) && Objects.nonNull(epcisBody.getEvent());
  }

  public boolean hasErrorDeclarationEvent() {
    if (Objects.nonNull(epcisBody)
        && Objects.nonNull(epcisBody.getEventList())
        && !epcisBody.getEventList().isEmpty()) {

      return epcisBody.getEventList().stream()
          .anyMatch(e -> Objects.nonNull(e.getErrorDeclaration()));
    }
    return false;
  }
}
