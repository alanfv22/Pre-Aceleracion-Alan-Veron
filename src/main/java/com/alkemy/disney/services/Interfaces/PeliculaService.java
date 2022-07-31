package com.alkemy.disney.services.Interfaces;

import com.alkemy.disney.DTOS.PeliculaBasicDTO;
import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PeliculaUpdateDTO;

import java.util.List;

public interface PeliculaService {

    PeliculaDTO getById(Long id);

    PeliculaDTO save(PeliculaDTO DTO);

    void delete(Long id);

    PeliculaDTO update(PeliculaUpdateDTO pelicula);

    List<PeliculaBasicDTO> getByFilters(String titulo, Long generoId, String order);

    void addCharacter(Long idMovie, Long idCharacter);

    void deleteCharacter(Long idMovie, Long idCharacter);
}
