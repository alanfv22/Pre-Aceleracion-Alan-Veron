package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;

import java.util.Set;

public interface PersonajeService {

    PersonajeDTO getById(Long id);
    PersonajeDTO save(PersonajeDTO DTO);
    void delete(Long id);
    Set<PersonajeDTO> getAll();
    PersonajeDTO update(PersonajeBasicDTO personaje);
}
