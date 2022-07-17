package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.GeneroDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;

import java.util.List;

public interface PersonajeService {

    PersonajeDTO getById(Long id);
    PersonajeDTO save(PersonajeDTO DTO);
    void delete(Long id);
    List<PersonajeDTO> getAll();


}
