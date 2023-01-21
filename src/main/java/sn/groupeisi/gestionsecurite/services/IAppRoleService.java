package sn.groupeisi.gestionsecurite.services;

import sn.groupeisi.gestionsecurite.dtos.AppRoles;

public interface IAppRoleService extends IBaseService<AppRoles> {
    public AppRoles findByName(String name);
    public void delete(int id);
    public AppRoles update(String name, AppRoles appRoles);
}
