package sn.groupeisi.gestionsecurite.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.gestionsecurite.dtos.AppRoles;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRole(AppRoleEntity appRoleEntity); //  Transformation d'un DAO vers un DTO
    AppRoleEntity fromAppRole(AppRoles appRole);  //  Transformation d'un TDO vers un DAO

}
