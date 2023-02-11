package sn.groupeisi.gestionsecurite;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;
import sn.groupeisi.gestionsecurite.services.IAppRoleService;
import sn.groupeisi.gestionsecurite.services.IAppUserService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class GestionSecuriteApplication implements CommandLineRunner {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionSecuriteApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //add role
//        AppRole appRole = new AppRole();
//        appRole.setName("USER");
//        iAppRole.save(appRole);
        //add user
//        AppUser appUser = new AppUser();
//        appUser.setLastName("Kane");
//        appUser.setFirsName("Aboubakry");
//        appUser.setEmail("kane@gmail.com");
//        appUser.setPassword("passer");
//        List<AppRole> roles = new ArrayList<AppRole>();
//        roles.add(iAppRole.findById(1));
//        roles.add(iAppRole.findById(2));
//        appUser.setRoles(roles);
//        iAppUser.save(appUser);

//        List<AppRoleEntity> appRoles = new ArrayList<>();
//               appRoles = iAppRole.findAll();
//        appRoles.forEach(role -> {
//            System.out.println(role);
//        });
   }
}
