package sn.groupeisi.findjob.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.findjob.security.entities.AppRoleEntity;

import java.util.Optional;

public interface AppRoleRepository extends JpaRepository<AppRoleEntity, Integer> {
    Optional<AppRoleEntity> findByName(String name);
}
