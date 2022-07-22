package com.alkemy.disney.mapper;



import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.repository.PersonajeRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Component
public class PeliculaMapper {

    @Autowired
    PersonajeMapper personajeMapper;



    public PeliculaEntity peliculaDTO2Entity (PeliculaDTO dto){
        PeliculaEntity peliculaEntity = new PeliculaEntity();
        peliculaEntity.setImagen(dto.getImagen());
        peliculaEntity.setTitulo(dto.getTitulo());
        peliculaEntity.setFechaCreacion(dto.getFechaCreacion());
        peliculaEntity.setCalificacion(dto.getCalificacion());
        peliculaEntity.setGeneroId(dto.getGeneroId());

        return peliculaEntity;
    }

    public PeliculaDTO peliculaEntity2DTO (PeliculaEntity entity, Boolean cargarPersonajes){

        PeliculaDTO peliculaDTO = new PeliculaDTO();
        Set <PersonajeDTO> personajesDTO;

        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaCreacion(entity.getFechaCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());
        peliculaDTO.setGeneroId(entity.getGeneroId());
        peliculaDTO.setPeliculaId(entity.getPeliculaId());


        if(cargarPersonajes) {
            personajesDTO=  personajeMapper.personajeEntity2DTOList(entity.getPersonajes(),false);
            peliculaDTO.setPersonajes(personajesDTO);
        }


        return peliculaDTO;
    }

    public Set<PeliculaDTO> peliculaEntity2DTOList( Set<PeliculaEntity> entities,Boolean cargarPersonaje) {

        Set<PeliculaDTO> ret = new HashSet<>();

        for (PeliculaEntity entiti : entities)
            ret.add(peliculaEntity2DTO(entiti,cargarPersonaje));

        return ret;
    }


}
