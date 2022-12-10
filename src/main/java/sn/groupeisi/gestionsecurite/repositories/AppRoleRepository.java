package sn.groupeisi.gestionsecurite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.groupeisi.gestionsecurite.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Integer> {
}
