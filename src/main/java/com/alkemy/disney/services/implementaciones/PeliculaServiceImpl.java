package com.alkemy.disney.services.implementaciones;


import com.alkemy.disney.DTOS.PeliculaBasicDTO;
import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PeliculaFiltersDTO;
import com.alkemy.disney.DTOS.PeliculaUpdateDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repository.PeliculaRepository;
import com.alkemy.disney.repository.PersonajeRepository;
import com.alkemy.disney.repository.specifications.PeliculaSpecifications;
import com.alkemy.disney.services.Interfaces.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaMapper peliculaMapper;

    @Autowired
    PeliculaSpecifications peliculaSpecifications;

    @Autowired
    PersonajeRepository personajeRepository;

    @Override
    public PeliculaDTO getById(Long id) {
        PeliculaEntity entiti = peliculaRepository.getById(id);
        PeliculaDTO ret = peliculaMapper.peliculaEntity2DTO(entiti, true);
        return ret;
    }

    @Override
    public PeliculaDTO save(PeliculaDTO DTO) {
        // No se puede crear una pelicula con el mismo nombre
        Optional<PersonajeEntity> pelicula = peliculaRepository.findByTitulo(DTO.getTitulo());

        if (pelicula.isPresent())
            throw new ParamNotFound("La pelicula ya existe");

        else {
            PeliculaEntity entiti = peliculaMapper.peliculaDTO2Entity(DTO);
            PeliculaEntity peliculaSave = peliculaRepository.save(entiti);
            PeliculaDTO ret = peliculaMapper.peliculaEntity2DTO(peliculaSave, true);
            return ret;
        }
    }

    @Override
    public void delete(Long id) {

        if (!peliculaRepository.existsById(id))
            throw new ParamNotFound("La pelicula no existe");

        else peliculaRepository.deleteById(id);
    }


    @Override
    public PeliculaDTO update(PeliculaUpdateDTO peliculaUpdateDTO) {
        if (!peliculaRepository.existsById(peliculaUpdateDTO.getPeliculaId())) {
            throw new ParamNotFound("La pelicula no existe");
        } else {

            PeliculaEntity peliculaEntity = peliculaRepository.getReferenceById(peliculaUpdateDTO.getPeliculaId());
            PeliculaDTO peliculaDTO = peliculaMapper.peliculaEntity2DTO(peliculaEntity, true);
            PeliculaDTO res = peliculaMapper.peliculaUpdateDTO2peliculaFullDTO(peliculaDTO, peliculaUpdateDTO);
            peliculaMapper.refreshValues(peliculaEntity, res, false);
            peliculaRepository.save(peliculaEntity);
            return res;
        }

    }

    @Override
    public List<PeliculaBasicDTO> getByFilters(String titulo, Long generoId, String order) {
        PeliculaFiltersDTO peliculaFiltersDTO = new PeliculaFiltersDTO(titulo, generoId, order);
        List<PeliculaEntity> entities = peliculaRepository.findAll(this.peliculaSpecifications.getByFilters(peliculaFiltersDTO));
        List<PeliculaBasicDTO> dto = peliculaMapper.peliculaEntitySet2DTOList(entities);
        return dto;
    }

    @Override
    public void addCharacter(Long idMovie, Long idCharacter) {
        if (!peliculaRepository.existsById(idMovie))
            throw new ParamNotFound("La pelicula no existe");

        if (!personajeRepository.existsById(idCharacter))
            throw new ParamNotFound("El personaje no existe");

        PeliculaEntity peliculaEntity = peliculaRepository.getReferenceById(idMovie);
        peliculaEntity.agregarPersonaje(personajeRepository.getReferenceById(idCharacter));
        peliculaRepository.save(peliculaEntity);

    }

    @Override
    public void deleteCharacter(Long idMovie, Long idCharacter) {

        if (!peliculaRepository.existsById(idMovie))
            throw new ParamNotFound("La pelicula no existe");

        Set<PersonajeEntity> personajes= peliculaRepository.getReferenceById(idMovie).getPersonajes();

        if (!personajes.contains(personajeRepository.getReferenceById(idCharacter)))
            throw new ParamNotFound("El personaje no existe");

        PeliculaEntity peliculaEntity = peliculaRepository.getReferenceById(idMovie);
        peliculaEntity.quitarPersonaje(personajeRepository.getReferenceById(idCharacter));
        peliculaRepository.save(peliculaEntity);
    }
}
