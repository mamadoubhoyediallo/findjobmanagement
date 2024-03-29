package sn.groupeisi.findjob.security.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sn.groupeisi.findjob.security.dtos.AppRoles;
import sn.groupeisi.findjob.security.dtos.AppUser;
import sn.groupeisi.findjob.security.entities.AppUserEntity;
import sn.groupeisi.findjob.exception.EntityNotFoundException;
import sn.groupeisi.findjob.exception.RequestException;
import sn.groupeisi.findjob.security.mapping.AppUserMapper;
import sn.groupeisi.findjob.security.repositories.AppUserRepository;
import sn.groupeisi.findjob.security.service.IAppRoleService;
import sn.groupeisi.findjob.security.service.IAppUserService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements IAppUserService {

    private AppUserRepository appUserRepository;
    private IAppRoleService iAppRoleService;
    private AppUserMapper appUserMapper;
    private MessageSource messageSource;
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser loadUserByEmail(String email) {
        return appUserMapper.toAppUser(appUserRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{email},
                        Locale.getDefault()))));
    }

    @Override
    public AppUser findById(int id) {
        return appUserMapper.toAppUser(appUserRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Override
    public void delete(int id) {
        try {
            appUserRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("user.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Override
    public AppUser update(int id, AppUser appUser) {
        return appUserRepository.findById(id)
                .map(entity -> {
                    appUser.setId(id);
                    return appUserMapper.toAppUser(
                            appUserRepository.save(appUserMapper.fromAppUser(appUser)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("user.notfound", new Object[]{id},
                        Locale.getDefault())));
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        AppUser appUser = appUserMapper.toAppUser(appUserRepository.findByEmail(email).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("email.notfound", new Object[]{email},
                        Locale.getDefault()))));
        AppRoles appRole = iAppRoleService.findByName(roleName);
        appUser.getRoles().add(appRole);
    }

    @Override
    public AppUser save(AppUser appUser) {
        appUserRepository.findByEmail(appUser.getEmail())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("email.exists", new Object[]{appUser.getEmail()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });
        String password = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(password));
        AppUserEntity re = appUserMapper.fromAppUser(appUser);
        re = appUserRepository.save(re);
        return  appUserMapper.toAppUser(re);
    }

    @Override
    public List<AppUser> findAll() {
        return StreamSupport.stream(appUserRepository.findAll().spliterator(), false)
                .map(appUserMapper::toAppUser)
                .collect(Collectors.toList());
    }
}
