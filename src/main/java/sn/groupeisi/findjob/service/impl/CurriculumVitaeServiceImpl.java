package sn.groupeisi.findjob.service.impl;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.groupeisi.findjob.dtos.CurriculumVitaeDto;
import sn.groupeisi.findjob.entities.CurriculumVitae;
import sn.groupeisi.findjob.exception.EntityNotFoundException;
import sn.groupeisi.findjob.exception.RequestException;
import sn.groupeisi.findjob.mapping.CurriculumVitaeMapper;
import sn.groupeisi.findjob.repositories.CurriculumVitaeRepository;
import sn.groupeisi.findjob.service.ICurriculumVitaeService;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
@Slf4j
public class CurriculumVitaeServiceImpl implements ICurriculumVitaeService {

    private CurriculumVitaeRepository curriculumVitaeRepository;
    private CurriculumVitaeMapper curriculumVitaeMapper;
    private MessageSource messageSource;

    @Transactional
    public CurriculumVitaeDto save(CurriculumVitaeDto curriculumVitaeDto) {
        try {
            log.info("CurriculumVitaeService:createNewCurriculum execution started.");
            CurriculumVitae curriculumVitae = curriculumVitaeMapper.fromCurriculumVitaeDto(curriculumVitaeDto);
            log.debug("CurriculumVitaeService:createNewCurriculum request parameters {}", curriculumVitaeMapper.toCurriculumVitaeDto(curriculumVitae));
            curriculumVitae = curriculumVitaeRepository.save(curriculumVitae);
            curriculumVitaeDto = curriculumVitaeMapper.toCurriculumVitaeDto(curriculumVitae);
            log.debug("CurriculumVitaeService:createNewCurriculum received response from Database {}", curriculumVitaeMapper.fromCurriculumVitaeDto(curriculumVitaeDto));

        }catch (Exception ex){
            log.error("Exception occurred while persisting CurriculumVitae to database , Exception message {}", ex.getMessage());
        }

        log.info("CurriculumVitaeService:createNewCurriculum execution ended.");
        return curriculumVitaeDto;
    }

    @Override
    public List<CurriculumVitaeDto> findAll() {
        return StreamSupport.stream(curriculumVitaeRepository.findAll().spliterator(), false)
                .map(curriculumVitaeMapper::toCurriculumVitaeDto)
                .collect(Collectors.toList());
    }

    @Override
    public CurriculumVitaeDto findById(int id) {
        return curriculumVitaeMapper.toCurriculumVitaeDto(curriculumVitaeRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(messageSource.getMessage("curriculumVitae.notfound", new Object[]{id},
                        Locale.getDefault()))));
    }

    @Override
    public void delete(int id) {
        try {
            curriculumVitaeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RequestException(messageSource.getMessage("curriculumVitae.errordeletion", new Object[]{id},
                    Locale.getDefault()),
                    HttpStatus.CONFLICT);
        }
    }

    @Override
    public CurriculumVitaeDto update(int id, CurriculumVitaeDto curriculumVitaeDto) {
        return curriculumVitaeRepository.findById(id)
                .map(entity -> {
                    curriculumVitaeDto.setId(id);
                    return curriculumVitaeMapper.toCurriculumVitaeDto(
                            curriculumVitaeRepository.save(curriculumVitaeMapper.fromCurriculumVitaeDto(curriculumVitaeDto)));
                }).orElseThrow(() -> new EntityNotFoundException(messageSource.getMessage("curriculumVitae.notfound", new Object[]{id},
                        Locale.getDefault())));
    }
}
