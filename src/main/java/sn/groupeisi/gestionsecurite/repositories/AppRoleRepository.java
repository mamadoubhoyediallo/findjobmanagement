package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.gestionsecurite.entities.AppRoleEntity;

import java.util.Optional;

public interface AppRoleRepository extends JpaRepository<AppRoleEntity, Integer> {
    Optional<AppRoleEntity> findByName(String name);
}
