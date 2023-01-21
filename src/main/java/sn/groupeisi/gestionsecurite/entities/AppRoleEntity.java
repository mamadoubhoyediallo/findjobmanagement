package sn.groupeisi.gestionsecurite.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "approle")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRoleEntity extends BaseEntity {
    @Column(name = "name", nullable = false, length = 200, unique = true)
    private String name;
    @ManyToMany(mappedBy = "roles")
    List<AppUserEntity> users = new ArrayList<AppUserEntity>();
}
