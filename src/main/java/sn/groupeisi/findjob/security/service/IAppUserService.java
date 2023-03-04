package sn.groupeisi.findjob.security.service;


import sn.groupeisi.findjob.security.dtos.AppUser;
import sn.groupeisi.findjob.service.IBaseService;

public interface IAppUserService extends IBaseService<AppUser> {
    AppUser loadUserByEmail(String email);
    public AppUser findById(int id);
    public void delete(int id);
    public AppUser update(int id, AppUser appUser);
    void addRoleToUser(String username, String roleName);
}
