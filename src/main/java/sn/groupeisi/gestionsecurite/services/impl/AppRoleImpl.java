package sn.groupeisi.gestionsecurite.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import sn.groupeisi.gestionsecurite.entities.AppRole;
import sn.groupeisi.gestionsecurite.exception.EntityNotFoundException;
import sn.groupeisi.gestionsecurite.repositories.AppRoleRepository;
import sn.groupeisi.gestionsecurite.services.IAppRole;

import java.util.List;
import java.util.Locale;

@Service
public class AppRoleImpl implements IAppRole {

    private AppRoleRepository appRoleRepository;
    private MessageSource messageSource;

    public AppRoleImpl(AppRoleRepository appRoleRepository, MessageSource messageSource) {
        this.appRoleRepository = appRoleRepository;
        this.messageSource = messageSource;
    }

    @Override
    public AppRole save(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public AppRole update(AppRole appRole, int id) {
        AppRole appRole1 = appRoleRepository.findById(id).get();
        appRole1.setName(appRole.getName());
        return appRoleRepository.save(appRole1);
    }

    @Override
    public void delete(int id) {
         appRoleRepository.deleteById(id);
    }

    @Override
    public List<AppRole> findAll() {
        return appRoleRepository.findAll();
    }

    @Override
    public AppRole findById(int id) {
        return appRoleRepository.findById(id).
                orElseThrow(()-> new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{id},
                        Locale.getDefault())));
    }
}
