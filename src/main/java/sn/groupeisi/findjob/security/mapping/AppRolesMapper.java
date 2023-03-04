package sn.groupeisi.findjob.security.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.findjob.security.dtos.AppRoles;
import sn.groupeisi.findjob.security.entities.AppRoleEntity;

@Mapper
public interface AppRolesMapper {
    AppRoles toAppRole(AppRoleEntity appRoleEntity); //  Transformation d'un DAO vers un DTO
    AppRoleEntity fromAppRole(AppRoles appRole);  //  Transformation d'un TDO vers un DAO

}
