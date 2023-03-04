package sn.groupeisi.findjob.security.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.findjob.security.dtos.AppUser;
import sn.groupeisi.findjob.security.entities.AppUserEntity;

@Mapper
public interface AppUserMapper {
    AppUser toAppUser(AppUserEntity appUserEntity); //  Transformation d'un DAO vers un DTO
    AppUserEntity fromAppUser(AppUser appUser);  //  Transformation d'un TDO vers un DAO
}
