package com.alkemy.disney.mapper;

import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.DTOS.PersonajeUpdateDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonajeMapper {

    @Autowired
    PeliculaMapper peliculaMapper;

    public PersonajeEntity personajeDTO2Entity(PersonajeDTO dto) {
        PersonajeEntity personajeEntity = new PersonajeEntity();

        convertBasicValues(personajeEntity, dto);

        return personajeEntity;
    }

    private void convertBasicValues(PersonajeEntity personajeEntity, PersonajeDTO dto) {
        refreshValues(personajeEntity, dto);
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

        if (cargarPeliculas) {
            peliculasDTO = peliculaMapper.peliculaEntity2DTOList(entity.getPeliculas(), false);
            personajeDTO.setPeliculas(peliculasDTO);
        }

        return personajeDTO;
    }

    public Set<PersonajeDTO> personajeEntity2DTOList(Set<PersonajeEntity> entities, Boolean cargarPelicula) {

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


    public PersonajeDTO refreshValues(PersonajeEntity personajeEntity, PersonajeDTO dto) {

        personajeEntity.setImagen(dto.getImagen());
        personajeEntity.setNombre(dto.getNombre());
        personajeEntity.setEdad(dto.getEdad());
        personajeEntity.setPeso(dto.getPeso());
        personajeEntity.setHistoria(dto.getHistoria());

        return dto;
    }

    public List<PersonajeBasicDTO> personajeEntitySet2DTOList(List<PersonajeEntity> entities) {

        List<PersonajeBasicDTO> ret= new ArrayList<>();

        for (PersonajeEntity entiti : entities)
            ret.add(personajeEntity2BasicDTO(entiti));

        return ret;
    }

    private PersonajeBasicDTO personajeEntity2BasicDTO(PersonajeEntity entiti) {

        PersonajeBasicDTO personajeBasicDTO= new PersonajeBasicDTO();

        personajeBasicDTO.setImagen(entiti.getImagen());
        personajeBasicDTO.setNombre(entiti.getNombre());

        return personajeBasicDTO;
    }

    public PersonajeDTO personajeUpdateDTO2personajeFullDTO(PersonajeDTO personajeDTO, PersonajeUpdateDTO personajeUpdateDTO) {

        personajeDTO.setPeso(personajeUpdateDTO.getPeso());
        personajeDTO.setImagen(personajeUpdateDTO.getImagen());
        personajeDTO.setNombre(personajeUpdateDTO.getNombre());
        personajeDTO.setHistoria(personajeUpdateDTO.getHistoria());
        personajeDTO.setEdad(personajeUpdateDTO.getEdad());

        return personajeDTO;
    }
}
