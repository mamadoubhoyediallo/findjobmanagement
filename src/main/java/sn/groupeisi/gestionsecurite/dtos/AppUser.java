package sn.groupeisi.gestionsecurite.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends Base {
    private String firsName;
    private String lastName;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
   List<AppRoles> roles = new ArrayList<AppRoles>();

}
