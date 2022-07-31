package com.alkemy.disney.mapper;


import com.alkemy.disney.DTOS.PeliculaBasicDTO;
import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PeliculaUpdateDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.entities.PeliculaEntity;
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


    public PeliculaEntity peliculaDTO2Entity(PeliculaDTO dto) {

        PeliculaEntity peliculaEntity = new PeliculaEntity();

        convertBasicValues(peliculaEntity, dto);


        return peliculaEntity;
    }

    private void convertBasicValues(PeliculaEntity peliculaEntity, PeliculaDTO dto) {
        refreshValues(peliculaEntity, dto, true);
    }

    public PeliculaDTO peliculaEntity2DTO(PeliculaEntity entity, Boolean cargarPersonajes) {

        PeliculaDTO peliculaDTO = new PeliculaDTO();
        Set<PersonajeDTO> personajesDTO;

        peliculaDTO.setImagen(entity.getImagen());
        peliculaDTO.setTitulo(entity.getTitulo());
        peliculaDTO.setFechaCreacion(entity.getFechaCreacion());
        peliculaDTO.setCalificacion(entity.getCalificacion());
        peliculaDTO.setGeneroId(entity.getGeneroId());
        peliculaDTO.setPeliculaId(entity.getPeliculaId());

        if (cargarPersonajes) {
            personajesDTO = personajeMapper.personajeEntity2DTOList(entity.getPersonajes(), false);
            peliculaDTO.setPersonajes(personajesDTO);
        }


        return peliculaDTO;
    }

    public Set<PeliculaDTO> peliculaEntity2DTOList(Set<PeliculaEntity> entities, Boolean cargarPersonaje) {

        Set<PeliculaDTO> ret = new HashSet<>();

        for (PeliculaEntity entiti : entities)
            ret.add(peliculaEntity2DTO(entiti, cargarPersonaje));

        return ret;
    }


    public PeliculaDTO refreshValues(PeliculaEntity peliculaEntity, PeliculaDTO peliculaDTO, Boolean actualizarPersonajes) {

        peliculaEntity.setCalificacion(peliculaDTO.getCalificacion());
        peliculaEntity.setImagen(peliculaDTO.getImagen());
        peliculaEntity.setGeneroId(peliculaDTO.getGeneroId());
        peliculaEntity.setFechaCreacion(peliculaDTO.getFechaCreacion());
        peliculaEntity.setTitulo(peliculaDTO.getTitulo());

        if (actualizarPersonajes)
            peliculaEntity.setPersonajes(personajeMapper.personajeDTO2EntityList(peliculaDTO.getPersonajes()));

        return peliculaDTO;

    }

    public PeliculaDTO peliculaUpdateDTO2peliculaFullDTO(PeliculaDTO dto, PeliculaUpdateDTO update) {
        dto.setCalificacion(update.getCalificacion());
        dto.setTitulo(update.getTitulo());
        dto.setImagen(update.getImagen());
        dto.setFechaCreacion(update.getFechaCreacion());
        dto.setGeneroId(update.getGeneroId());

        return dto;
    }

    public List<PeliculaBasicDTO> peliculaEntitySet2DTOList(List<PeliculaEntity> entities) {

        List<PeliculaBasicDTO> ret = new ArrayList<>();


        for (PeliculaEntity entiti : entities)
            ret.add(peliculaEntity2BasicDTO(entiti));

        return ret;
    }

    private PeliculaBasicDTO peliculaEntity2BasicDTO(PeliculaEntity entiti) {

        PeliculaBasicDTO peliculaBasicDTO = new PeliculaBasicDTO();


        peliculaBasicDTO.setImagen(entiti.getImagen());
        peliculaBasicDTO.setTitulo(entiti.getTitulo());
        peliculaBasicDTO.setFechaCreación(entiti.getFechaCreacion());

        return peliculaBasicDTO;

    }
}
