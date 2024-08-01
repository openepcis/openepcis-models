package io.openepcis.model.rolesmodel;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDefinition {

    public List<String> cluster_permissions;
    public List<IndexPermission> index_permissions;
    public List<TenantPermission> tenant_permissions;

    public static class IndexPermission {
        public List<String> index_patterns;
        public List<String> fls;
        public List<String> masked_fields;
        public List<String> allowed_actions;
        public String dls;
    }

    public static class TenantPermission {
        public List<String> tenant_patterns;
        public List<String> allowed_actions;
    }
}
