package com.alkemy.disney.services.Interfaces;

import com.alkemy.disney.DTOS.GeneroDTO;

import java.util.List;

public interface GeneroService {

    GeneroDTO save(GeneroDTO dto);

    List<GeneroDTO> getAll();

}


