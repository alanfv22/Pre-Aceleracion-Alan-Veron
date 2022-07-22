package com.alkemy.disney.mapper;

import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class PersonajeMapper {

    @Autowired
    PeliculaMapper peliculaMapper;

    @Autowired
    PersonajeRepository personajeRepository;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity personajeEntity = new PersonajeEntity();
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());
        return personajeEntity;
    }

    public PersonajeDTO personajeEntity2DTO(PersonajeEntity entity, Boolean cargarPeliculas) {
        PersonajeDTO personajeDTO = new PersonajeDTO();
        Set<PeliculaDTO> peliculasDTO;
        personajeDTO.setImagen(entity.getImagen());
        personajeDTO.setNombre(entity.getNombre());
        personajeDTO.setEdad(entity.getEdad());
        personajeDTO.setPeso(entity.getPeso());
        personajeDTO.setHistoria(entity.getHistoria());
        personajeDTO.setPersonajeId(entity.getPersonajeId());

        if(cargarPeliculas){
            peliculasDTO =  peliculaMapper.peliculaEntity2DTOList(entity.getPeliculas(),false);
            personajeDTO.setPeliculas(peliculasDTO);
        }

        return personajeDTO;
    }

    public Set<PersonajeDTO> personajeEntity2DTOList(Set<PersonajeEntity> entities,Boolean cargarPelicula) {

        Set<PersonajeDTO> ret = new HashSet<>();

        for (PersonajeEntity entiti : entities)
            ret.add(personajeEntity2DTO(entiti, cargarPelicula));

        return ret;
    }

    public Set<PersonajeEntity> personajeDTO2EntityList(Set<PersonajeDTO> entities) {

        Set<PersonajeEntity> ret = new HashSet<>();

        for (PersonajeDTO entiti : entities)
            ret.add(personajeDTO2Entity(entiti));

        return ret;
    }


    public PersonajeEntity personajeBasicDTO2Entity(PersonajeBasicDTO dto) {

        PersonajeEntity  personajeEntity =  personajeRepository.getById(dto.getPersonajeId());

        //TODO: seguir aca
        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());

        return personajeEntity;



    }
}
