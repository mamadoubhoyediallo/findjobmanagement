package sn.groupeisi.findjob.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "curriculumvitae")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor @Data
public class CurriculumVitae extends BaseEntity {
    @Column(name = "firstname", length = 200)
    String firstName;
    @Column(name = "lastname", length = 200)
    String lastName;
    @Column(name = "age", length = 200)
    String age;
    String address;
    String email;
    String phone;
    @Column(name = "levelofstudy", length = 200)
    String levelOfStudy;
    @Column(name = "professionalexperience", length = 200)
    String professionalExperience;
}
