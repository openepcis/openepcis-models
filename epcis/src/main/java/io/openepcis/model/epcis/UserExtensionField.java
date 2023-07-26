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
package io.openepcis.model.epcis;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.openepcis.model.epcis.exception.CaptureValidationException;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserExtensionField {
  private String name;
  private String type;
  private Date createdAt;

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
  }

  @Override
  public boolean equals(Object o) {

    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }

    /* Check if o is an instance of UserExtensionField or not
    "null instanceof [type]" also returns false */
    if (!(o instanceof UserExtensionField)) {
      return false;
    }

    // typecast o to UserExtensionField so that we can compare data members
    UserExtensionField c = (UserExtensionField) o;

    // Compare the data members and return accordingly
    if (c.getName().equals(this.getName()) && c.getType().equals(this.getType())) return true;
    else if (c.getName().equals(this.getName()) && !c.getType().equals(this.getType()))
      throw new CaptureValidationException(c.getName() + "expected data type: " + this.getType());

    return false;
  }
}
