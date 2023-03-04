package sn.groupeisi.findjob.security.service;

import sn.groupeisi.findjob.security.dtos.AppRoles;
import sn.groupeisi.findjob.service.IBaseService;

public interface IAppRoleService extends IBaseService<AppRoles> {
    public AppRoles findByName(String name);
    public void delete(int id);
    public AppRoles update(String name, AppRoles appRoles);
}
