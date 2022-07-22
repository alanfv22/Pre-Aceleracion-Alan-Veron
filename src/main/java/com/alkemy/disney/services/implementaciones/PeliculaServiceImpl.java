package com.alkemy.disney.services.implementaciones;


import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaMapper peliculaMapper;

    @Override
    public PeliculaDTO getById(Long id) {
        PeliculaEntity entiti = peliculaRepository.getById(id);
        PeliculaDTO ret= peliculaMapper.peliculaEntity2DTO(entiti,true);
        return ret;
    }

    @Override
    public PeliculaDTO save(PeliculaDTO DTO) {
        PeliculaEntity entiti= peliculaMapper.peliculaDTO2Entity(DTO);
        PeliculaEntity peliculaSave= peliculaRepository.save(entiti);
        PeliculaDTO ret= peliculaMapper.peliculaEntity2DTO(peliculaSave,true);
        return ret;
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public Set<PeliculaDTO> getAll() {
        Set <PeliculaEntity> entities= new HashSet<PeliculaEntity>();
        List<PeliculaEntity> a =peliculaRepository.findAll();
        for(PeliculaEntity pelicula : a)
            entities.add(pelicula);
        Set<PeliculaDTO> ret= peliculaMapper.peliculaEntity2DTOList(entities,true);
        return ret;

    }
}
