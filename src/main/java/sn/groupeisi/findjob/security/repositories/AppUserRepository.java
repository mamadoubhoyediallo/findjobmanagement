package sn.groupeisi.findjob.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.findjob.security.entities.AppUserEntity;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
    Optional<AppUserEntity> findByEmail(String email);
}
