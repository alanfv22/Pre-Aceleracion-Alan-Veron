package com.alkemy.disney.mapper;

import com.alkemy.disney.DTOS.GeneroDTO;
import com.alkemy.disney.entities.GeneroEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GeneroMapper {

    public GeneroEntity generoDTO2Entity(GeneroDTO dto) {
        GeneroEntity generoEntity = new GeneroEntity();
        generoEntity.setImagen(dto.getImagen());
        generoEntity.setNombre(dto.getNombre());
        return generoEntity;
    }

    public GeneroDTO generoEntity2DTO(GeneroEntity entity) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setImagen(entity.getImagen());
        generoDTO.setNombre(entity.getNombre());
        generoDTO.setGeneroId(entity.getGeneroId());

        return generoDTO;
    }

    public List<GeneroDTO> generoEntity2DTOList(List<GeneroEntity> entities) {

        List<GeneroDTO> ret = new ArrayList<>();

        for (GeneroEntity entiti : entities)
            ret.add(generoEntity2DTO(entiti));

        return ret;

    }
}
