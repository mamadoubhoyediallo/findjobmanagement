package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.gestionsecurite.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
}
