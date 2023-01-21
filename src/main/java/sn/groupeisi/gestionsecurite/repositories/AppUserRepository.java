package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.gestionsecurite.entities.AppUserEntity;

public interface AppUserRepository extends JpaRepository<AppUserEntity, Integer> {
}
