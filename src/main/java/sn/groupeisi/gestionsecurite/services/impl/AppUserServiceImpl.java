package sn.groupeisi.gestionsecurite.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sn.groupeisi.gestionsecurite.dtos.AppUser;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;
import sn.groupeisi.gestionsecurite.exception.EntityNotFoundException;
import sn.groupeisi.gestionsecurite.exception.RequestException;
import sn.groupeisi.gestionsecurite.mapping.AppUserMapper;
import sn.groupeisi.gestionsecurite.repositories.AppUserRepository;
import sn.groupeisi.gestionsecurite.services.IAppUserService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class AppUserServiceImpl implements IAppUserService {

    private AppUserRepository appUserRepository;
    private AppUserMapper appUserMapper;
    private MessageSource messageSource;

    @Override
    public AppUser loaduser(String username) {
        return null;
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
    public AppUser save(AppUser appUser) {
        appUserRepository.findByEmail(appUser.getEmail())
                .ifPresent(entity -> {
                    throw new RequestException(messageSource.getMessage("user.exists", new Object[]{appUser.getEmail()},
                            Locale.getDefault()), HttpStatus.CONFLICT);
                });

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
