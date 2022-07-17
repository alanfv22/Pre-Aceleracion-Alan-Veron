package com.alkemy.disney.mapper;

import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonajeMapper {


    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());
        personajeDTO.setPersonajeId(entity.getPersonajeId());

        return personajeDTO;
    }

    public List<PersonajeDTO> personajeEntity2DTOList(List<PersonajeEntity> entities) {

        List<PersonajeDTO> ret = new ArrayList<>();

        for (PersonajeEntity entiti : entities)
            ret.add(personajeEntity2DTO(entiti));

        return ret;
    }
}
