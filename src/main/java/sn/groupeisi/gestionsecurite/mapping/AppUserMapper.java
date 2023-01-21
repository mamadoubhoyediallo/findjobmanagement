package sn.groupeisi.gestionsecurite.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.gestionsecurite.dtos.AppRoles;
import sn.groupeisi.gestionsecurite.dtos.AppUser;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;

@Mapper
public interface AppUserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity); //  Transformation d'un DAO vers un DTO
    AppUserEntity fromAppUser(AppUser appUser);  //  Transformation d'un TDO vers un DAO
}
