package com.alkemy.disney.repository.specifications;


import com.alkemy.disney.DTOS.PersonajeFiltersDTO;
import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonajeSpecifications {

    public Specification<PersonajeEntity> getByFilters(PersonajeFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getNombre())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("nombre")),
                                "%" + filtersDTO.getNombre().toLowerCase() + "%"
                        )
                );
            }


            if (StringUtils.hasLength(String.valueOf(filtersDTO.getEdad()))) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("edad")),
                                "%" + filtersDTO.getEdad() + "%"
                        )
                );
            }

            if (!CollectionUtils.isEmpty(filtersDTO.getPeliculas())) {
                Join<PeliculaEntity, PersonajeEntity> join = root.join("peliculas", JoinType.INNER);
                Expression<String> peliculasId = join.get("id");
                predicateList.add(peliculasId.in(filtersDTO.getPeliculas()));
            }

            // remover duplicados
            query.distinct(true);

            return  criteriaBuilder.and(predicateList.toArray(predicateList.toArray(new Predicate[0])));
        };
    }
}
