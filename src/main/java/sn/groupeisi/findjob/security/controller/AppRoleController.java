package sn.groupeisi.findjob.security.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.findjob.security.dtos.AppRoles;
import sn.groupeisi.findjob.security.service.IAppRoleService;
import sn.groupeisi.findjob.utils.EndPoint;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "roles")
@AllArgsConstructor
public class AppRoleController {

    private IAppRoleService iAppRoleService;

    @PostMapping(path = EndPoint.SAVE)
    public AppRoles save(@Valid @RequestBody AppRoles appRoles){
        return iAppRoleService.save(appRoles);
    }

    @GetMapping(path = EndPoint.FIND_ALL)
    public List<AppRoles> findAll() {
        return iAppRoleService.findAll();
    }

    @GetMapping(path = EndPoint.FIND_BY_NAME)
    public AppRoles getAppRole(@PathVariable("name") String name) {
        return iAppRoleService.findByName(name);
    }

    @PutMapping(path = EndPoint.UPDATE_BY_NAME)
    public AppRoles updateAppRole(@PathVariable("name") String name, @Valid @RequestBody AppRoles appRoles) {
        return iAppRoleService.update(name, appRoles);
    }

    @DeleteMapping(path = EndPoint.DELETE)
    public void deleteAppRole(@PathVariable("id") int id) {
        iAppRoleService.delete(id);
    }

}
