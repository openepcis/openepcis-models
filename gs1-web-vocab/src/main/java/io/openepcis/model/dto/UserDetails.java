package io.openepcis.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private String name;
    private String email;
    private String password;
    private String defaultGroup;
    private List<String> groups;
}
