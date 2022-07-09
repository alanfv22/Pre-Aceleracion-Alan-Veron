package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.GeneroDTO;

import java.util.List;

public interface GeneroService {

    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAll();

}


