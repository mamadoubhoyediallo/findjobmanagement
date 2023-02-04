package sn.groupeisi.gestionsecurite.services;

import sn.groupeisi.gestionsecurite.dtos.AppUser;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;

public interface IAppUserService extends IBaseService<AppUser> {
    AppUser loaduser(String username);
    public AppUser findById(int id);
    public void delete(int id);
    public AppUser update(int id, AppUser appUser);
}
