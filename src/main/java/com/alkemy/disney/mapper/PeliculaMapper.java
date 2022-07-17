package com.alkemy.disney.mapper;



import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import org.springframework.stereotype.Component;


@Component
public class PeliculaMapper {

    public PeliculaEntity peliculaDTO2Entity (PeliculaDTO dto){
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaCreacion(dto.getFechaCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());
        peliculaEntity.setPersonajes(dto.getPersonajes());

        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO (PeliculaEntity entity){

        PeliculaDTO peliculaDTO = new PeliculaDTO();

        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaCreacion(entity.getFechaCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());
        peliculaDTO.setGeneroId(entity.getGeneroId());
        peliculaDTO.setPeliculaId(entity.getPeliculaId());
        peliculaDTO.setPersonajes(entity.getPersonajes());

        return peliculaDTO;
    }



}
