package sn.groupeisi.gestionsecurite.services.impl;

import org.springframework.stereotype.Service;
import sn.groupeisi.gestionsecurite.entities.AppUser;
import sn.groupeisi.gestionsecurite.repositories.AppUserRepository;
import sn.groupeisi.gestionsecurite.services.IAppUser;

import java.util.List;
@Service
public class AppUserImpl implements IAppUser {

    private AppUserRepository appUserRepository;

    public AppUserImpl(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public AppUser save(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    @Override
    public AppUser update(AppUser appUser, int id) {
        AppUser appUser1 = appUserRepository.findById(id).get();
        appUser1.setFirsName(appUser.getFirsName());
        appUser1.setLastName(appUser.getLastName());
        return appUserRepository.save(appUser1);
    }

    @Override
    public void delete(int id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser findById(int id) {
        return appUserRepository.findById(id).get();
    }
}
