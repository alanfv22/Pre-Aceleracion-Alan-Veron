package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.PersonajeDTO;

import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    PersonajeMapper personajeMapper;
    @Autowired
    PersonajeRepository personajeRepository;


    @Override
    public PersonajeDTO save(PersonajeDTO dto) {
        PersonajeEntity entity=  personajeMapper.personajeDTO2Entity(dto);
        PersonajeEntity personajeSave= personajeRepository.save(entity);
        PersonajeDTO res= personajeMapper.personajeEntity2DTO(personajeSave);
        return res;

    }

    @Override
    public List<PersonajeDTO>  getAll(){
        List<PersonajeEntity> entities= personajeRepository.findAll();
        List<PersonajeDTO> ret= personajeMapper.personajeEntity2DTOList(entities);
        return ret;

    }
    @Override
    public void delete(Long id) {
       personajeRepository.deleteById(id);
    }
    @Override
    public PersonajeDTO getById(Long id){
        PersonajeEntity entiti= personajeRepository.getById(id);
        PersonajeDTO ret= personajeMapper.personajeEntity2DTO(entiti);
        return ret;


    }
}
