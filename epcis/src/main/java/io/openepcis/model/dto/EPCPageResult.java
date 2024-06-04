package io.openepcis.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.openepcis.core.model.PaginationSupport;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class EPCPageResult extends PaginationSupport {

    @JsonProperty("@context")
    private List<Object> contextInfo;

    @JsonProperty("type")
    private String type;

    @JsonProperty("member")
    private List<String> member = new ArrayList<>();
}
