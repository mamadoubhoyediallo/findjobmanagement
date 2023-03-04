package sn.groupeisi.findjob.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.findjob.security.dtos.AppUser;
import sn.groupeisi.findjob.security.entities.AppUserEntity;
import sn.groupeisi.findjob.security.entities.RoleUserForm;
import sn.groupeisi.findjob.security.repositories.AppUserRepository;
import sn.groupeisi.findjob.security.service.IAppUserService;
import sn.groupeisi.findjob.utils.EndPoint;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "user")
@AllArgsConstructor
public class AppUserController {

    private IAppUserService iAppUserService;
    private AppUserRepository appUserRepository;

    @PostMapping(path = EndPoint.SAVE)
    public AppUser save(@Valid @RequestBody AppUser appUser){
        return iAppUserService.save(appUser);
    }

    @GetMapping(path = EndPoint.FIND_ALL)
    public List<AppUser> findAll() {
        return iAppUserService.findAll();
    }

    @GetMapping(path = EndPoint.FIND_BY_ID)
    public AppUser getAppUser(@PathVariable("id") int id) {
        return iAppUserService.findById(id);
    }

    @PutMapping(path = EndPoint.UPDATE)
    public AppUser updateAppRole(@PathVariable("id") int id, @Valid @RequestBody AppUser appUser) {
        return iAppUserService.update(id, appUser);
    }

    @DeleteMapping(path = EndPoint.DELETE)
    public void deleteAppRole(@PathVariable("id") int id) {
        iAppUserService.delete(id);
    }
    @PostMapping(path = "/addRoleToUser")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
        iAppUserService.addRoleToUser(roleUserForm.getEmail(), roleUserForm.getRoleName());
    }
    @GetMapping(path = "all")
    public List<AppUserEntity> findAlls() {
        return appUserRepository.findAll();
    }
}
