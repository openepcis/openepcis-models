package io.openepcis.model.rolesmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDefinition {

    private List<String> cluster_permissions;
    private List<IndexPermission> index_permissions;
    private List<TenantPermission> tenant_permissions;

    @Builder
    @Data
    public static class IndexPermission {
        private List<String> index_patterns;
        private List<String> fls;
        private List<String> masked_fields;
        private List<String> allowed_actions;
        private String dls;
    }

    @Builder
    @Data
    public static class TenantPermission {
        private List<String> tenant_patterns;
        private List<String> allowed_actions;
    }
}
