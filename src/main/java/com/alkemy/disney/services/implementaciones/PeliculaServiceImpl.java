package com.alkemy.disney.services.implementaciones;


import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.mapper.PeliculaMapper;
import com.alkemy.disney.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeliculaServiceImpl implements PeliculaService{

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    PeliculaMapper peliculaMapper;

    @Override
    public PeliculaDTO getById(Long id) {
        PeliculaEntity entiti = peliculaRepository.getById(id);
        PeliculaDTO ret= peliculaMapper.peliculaEntity2DTO(entiti);
        return ret;
    }

    @Override
    public PeliculaDTO save(PeliculaDTO DTO) {
        PeliculaEntity entiti= peliculaMapper.peliculaDTO2Entity(DTO);
        PeliculaEntity peliculaSave= peliculaRepository.save(entiti);
        PeliculaDTO ret= peliculaMapper.peliculaEntity2DTO(peliculaSave);
        return ret;
    }


    @Override
    public void delete(Long id) {

    }

    @Override
    public List<PeliculaDTO> getAll() {
        return null;
    }
}
