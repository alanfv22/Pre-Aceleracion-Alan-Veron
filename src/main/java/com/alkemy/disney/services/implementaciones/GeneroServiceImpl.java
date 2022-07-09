package com.alkemy.disney.services.implementaciones;

import com.alkemy.disney.DTOS.GeneroDTO;
import com.alkemy.disney.entities.GeneroEntity;
import com.alkemy.disney.mapper.GeneroMapper;
import com.alkemy.disney.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    GeneroMapper generoMapper;
    @Autowired
    GeneroRepository generoRepository;

    public GeneroDTO save(GeneroDTO dto){

        GeneroEntity entity = generoMapper.GeneroDTO2Entity(dto);
        GeneroEntity generoSave= generoRepository.save(entity);
        GeneroDTO res = generoMapper.GeneroEntity2DTO(generoSave);
        return res;
    }

    public List<GeneroDTO> getAll(){
        List<GeneroEntity> entities= generoRepository.findAll();
        List<GeneroDTO> ret = generoMapper.GeneroEntity2DTOList(entities);

        return ret;
    }
}
