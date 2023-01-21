package sn.groupeisi.gestionsecurite.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser extends Base {
    private String firsName;
    private String lastName;
    private String email;
    private String password;
}
