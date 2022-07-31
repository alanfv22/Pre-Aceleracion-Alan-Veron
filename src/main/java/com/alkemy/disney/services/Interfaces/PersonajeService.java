package com.alkemy.disney.services.Interfaces;

import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.DTOS.PersonajeUpdateDTO;

import java.util.List;
import java.util.Set;

public interface PersonajeService {

    PersonajeDTO getById(Long id);

    PersonajeDTO save(PersonajeDTO DTO);

    void delete(Long id);

    PersonajeDTO update(PersonajeUpdateDTO personaje);

    List<PersonajeBasicDTO> getByFilters(String nombre, int edad, Set<Long> peliculas, float peso);
}
