package sn.groupeisi.findjob.security.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.groupeisi.findjob.dtos.Base;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends Base {
    @NotNull
    private String firsName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
   List<AppRoles> roles = new ArrayList<AppRoles>();

}
