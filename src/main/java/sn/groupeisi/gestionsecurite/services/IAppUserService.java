package sn.groupeisi.gestionsecurite.services;

import sn.groupeisi.gestionsecurite.entities.AppUserEntity;

public interface IAppUserService extends IBaseService<AppUserEntity> {
    AppUserEntity loaduser(String username);
    public AppUserEntity findById(int id);
    public void delete(int id);
    public AppUserEntity update(int id, AppUserEntity appUser);
}
