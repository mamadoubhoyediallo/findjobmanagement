package sn.groupeisi.findjob.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import sn.groupeisi.findjob.dtos.CurriculumVitaeDto;
import sn.groupeisi.findjob.security.dtos.AppUser;
import sn.groupeisi.findjob.service.ICurriculumVitaeService;
import sn.groupeisi.findjob.utils.EndPoint;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("curriculumvitae")
@AllArgsConstructor
public class CurriculumVitaeContrioller {

    private ICurriculumVitaeService curriculumVitaeService;

    @PostMapping(path = EndPoint.SAVE)
    public CurriculumVitaeDto save(@Valid @RequestBody CurriculumVitaeDto curriculumVitaeDto){
        return curriculumVitaeService.save(curriculumVitaeDto);
    }
    @GetMapping(path = EndPoint.FIND_ALL)
    public List<CurriculumVitaeDto> findAll(){
        return curriculumVitaeService.findAll();
    }

    @PutMapping(path = EndPoint.UPDATE)
    public CurriculumVitaeDto update(@PathVariable("id") int id, @Valid @RequestBody CurriculumVitaeDto curriculumVitaeDto) {
        return curriculumVitaeService.update(id, curriculumVitaeDto);
    }
    @DeleteMapping(path = EndPoint.DELETE)
    public void delete(@PathVariable("id") int id) {
        curriculumVitaeService.delete(id);
    }
    @GetMapping(path = EndPoint.FIND_BY_ID)
    public CurriculumVitaeDto findById(@PathVariable("id") int id) {
        return curriculumVitaeService.findById(id);
    }
}
