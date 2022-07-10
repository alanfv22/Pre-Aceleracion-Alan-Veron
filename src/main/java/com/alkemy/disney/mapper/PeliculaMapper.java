package com.alkemy.disney.mapper;


import com.alkemy.disney.DTOS.GeneroDTO;
import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.entities.GeneroEntity;
import com.alkemy.disney.entities.PeliculaEntity;

import java.time.LocalDate;

public class PeliculaMapper {

    public PeliculaEntity PeliculaDTO2Entity (PeliculaDTO dto){

        PeliculaEntity peliculaEntity = new PeliculaEntity();

        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaCreacion(dto.getFechaCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());

        return peliculaEntity;
    }

    public PeliculaDTO PeliculaEntiy2DTO (PeliculaEntity entity){

        PeliculaDTO peliculaDTO = new PeliculaDTO();

        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaCreacion(entity.getFechaCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());

        return peliculaDTO;
    }



}
