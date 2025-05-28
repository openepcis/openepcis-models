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
package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = false)
@XmlRootElement(name = "Collection")
@NoArgsConstructor
public class TopLevelResource {

  @JsonProperty("@context")
  @XmlTransient
  private List<Object> contextInfo;

  @JsonProperty("type")
  private String type;

  @JsonProperty("member")
  private List<String> member = new ArrayList<>();

  public TopLevelResource(String type, List<String> member, List<Object> context) {
    this.type = type;
    this.member = member;
    this.contextInfo = context;

  }

  @Deprecated(forRemoval = true, since = "0.9.4")
  public TopLevelResource(List<String> member, List<Object> context) {
    this("collection", member, context);
  }
}
