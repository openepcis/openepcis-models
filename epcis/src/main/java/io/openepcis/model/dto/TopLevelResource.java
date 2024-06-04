package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class TopLevelResource {

    @JsonProperty("@context")
    private List<Object> contextInfo;

    @JsonProperty("type")
    private String type;

    @JsonProperty("member")
    private List<String> member = new ArrayList<>();
    public TopLevelResource(List<String> member, List<Object> context) {
        this.member = member;
        this.type = "collection";
        this.contextInfo = context;
    }
}
