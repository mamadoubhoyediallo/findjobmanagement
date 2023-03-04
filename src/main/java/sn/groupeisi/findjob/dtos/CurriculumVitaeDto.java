package sn.groupeisi.findjob.dtos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CurriculumVitaeDto extends Base {
    @NotNull
    String firstName;
    @NotNull
    String lastName;
    @NotNull
    String age;
    @NotNull
    String address;
    @NotNull
    String email;
    @NotNull
    String phone;
    @NotNull
    String levelOfStudy;
    @NotNull
    String professionalExperience;
}
