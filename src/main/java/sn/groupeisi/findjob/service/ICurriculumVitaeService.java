package sn.groupeisi.findjob.service;

import sn.groupeisi.findjob.dtos.CurriculumVitaeDto;
import sn.groupeisi.findjob.security.dtos.AppUser;

public interface ICurriculumVitaeService extends IBaseService<CurriculumVitaeDto>{
    CurriculumVitaeDto findById(int id);
    void delete(int id);
    CurriculumVitaeDto update(int id, CurriculumVitaeDto curriculumVitaeDto);
}
