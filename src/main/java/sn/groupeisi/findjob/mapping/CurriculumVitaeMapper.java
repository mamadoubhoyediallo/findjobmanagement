package sn.groupeisi.findjob.mapping;

import org.mapstruct.Mapper;
import sn.groupeisi.findjob.dtos.CurriculumVitaeDto;
import sn.groupeisi.findjob.entities.CurriculumVitae;

@Mapper
public interface CurriculumVitaeMapper {
    CurriculumVitaeDto toCurriculumVitaeDto(CurriculumVitae curriculumVitae);
    CurriculumVitae fromCurriculumVitaeDto(CurriculumVitaeDto curriculumVitaeDto);
}
