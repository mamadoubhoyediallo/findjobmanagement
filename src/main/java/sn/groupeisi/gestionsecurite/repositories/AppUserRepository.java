package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    Optional<AppUserEntity> findByEmail(String email);
}
