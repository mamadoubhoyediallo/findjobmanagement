package sn.groupeisi.findjob.security.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.groupeisi.findjob.security.dtos.AppRoles;
import sn.groupeisi.findjob.security.entities.AppRoleEntity;
import sn.groupeisi.findjob.exception.EntityNotFoundException;
import sn.groupeisi.findjob.exception.RequestException;
import sn.groupeisi.findjob.security.mapping.AppRolesMapper;
import sn.groupeisi.findjob.security.repositories.AppRoleRepository;
import sn.groupeisi.findjob.security.service.IAppRoleService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@CacheConfig(cacheNames = "roles")
@AllArgsConstructor
public class AppRoleServiceImpl implements IAppRoleService {

   private AppRoleRepository appRoleRepository;
   private AppRolesMapper appRoleMapper;
   private MessageSource messageSource;

    public List<AppRoles> findAll(){
        return StreamSupport.stream(appRoleRepository.findAll().spliterator(), false)
                .map(appRoleMapper::toAppRole)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public AppRoles update(String name, AppRoles appRole) {
        return appRoleRepository.findByName(name)
                .map(entity -> {
                    appRole.setName(name);
                    return appRoleMapper.toAppRole(
                            appRoleRepository.save(appRoleMapper.fromAppRole(appRole)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("employee.notfound", new Object[]{name},
                        Locale.getDefault())));
    }
    @Transactional
    public AppRoles save(AppRoles role) {
        appRoleRepository.findByName(role.getName())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("role.exists", new Object[]{role.getName()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
//        return appRoleMapper.toAppRole(appRoleRepository.save(appRoleMapper.fromAppRole(role)));

        AppRoleEntity re = appRoleMapper.fromAppRole(role);
        re = appRoleRepository.save(re);
        return  appRoleMapper.toAppRole(re);
    }


    @Cacheable(key = "#name")
    @Transactional(readOnly = true)
    public AppRoles findByName(String name) {
        return appRoleMapper.toAppRole(appRoleRepository.findByName(name).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("role.notfound", new Object[]{name},
                        Locale.getDefault()))));
    }

    @Transactional
    public void delete(int id) {
        try {
            appRoleRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("role.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

}
