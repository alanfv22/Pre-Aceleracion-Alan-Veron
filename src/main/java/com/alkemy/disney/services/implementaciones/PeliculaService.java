package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.PeliculaDTO;


import java.util.List;

public interface PeliculaService  {

    PeliculaDTO getById(Long id);
    PeliculaDTO save(PeliculaDTO DTO);
    void delete(Long id);
    List<PeliculaDTO> getAll();
}
