package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;

import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.mapper.PersonajeMapper;
import com.alkemy.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class PersonajeServiceImpl implements PersonajeService {

    @Autowired
    PersonajeMapper personajeMapper;
    @Autowired
    PersonajeRepository personajeRepository;


    @Override
    public PersonajeDTO save(PersonajeDTO dto) {
        Optional<PersonajeEntity> personaje = personajeRepository.findByNombre(dto.getNombre());
        if (personaje.isPresent()) {
            return null;// TODO:Implementar excepcion
        }
        else{


            PersonajeEntity entity = personajeMapper.personajeDTO2Entity(dto);
            PersonajeEntity personajeSave = personajeRepository.save(entity);
            PersonajeDTO res = personajeMapper.personajeEntity2DTO(personajeSave, false);
            return res;
        }
    }

    @Override
    public Set<PersonajeDTO>  getAll(){
        Set<PersonajeEntity> entities = new HashSet <PersonajeEntity> () ;
        List<PersonajeEntity> a =personajeRepository.findAll();
        for(PersonajeEntity personaje : a)
            entities.add(personaje);
            
        Set<PersonajeDTO> ret= personajeMapper.personajeEntity2DTOList(entities,true);
        return ret;

    }

    @Override
    public PersonajeDTO update(PersonajeBasicDTO dto) {

        Optional<PersonajeEntity> personaje = personajeRepository.findByNombre(dto.getNombre());

        if (!personaje.isPresent()) {
            return null;// TODO:Implementar excepcion
        }
        else{

            PersonajeEntity entity = personajeMapper.personajeBasicDTO2Entity(dto);
            PersonajeEntity personajeSave = personajeRepository.save(entity);
            PersonajeDTO res = personajeMapper.personajeEntity2DTO(personajeSave, false);
            return res;
        }


    }


    @Override
    public void delete(Long id) {
       personajeRepository.deleteById(id);
    }
    @Override
    public PersonajeDTO getById(Long id){
        PersonajeEntity entiti= personajeRepository.getById(id);
        PersonajeDTO ret= personajeMapper.personajeEntity2DTO(entiti,false);
        return ret;


    }
}
