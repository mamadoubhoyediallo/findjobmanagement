package sn.groupeisi.findjob.security.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.groupeisi.findjob.dtos.Base;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRoles extends Base {
    @NotNull(message = "name is required ")
    private String name;
}
