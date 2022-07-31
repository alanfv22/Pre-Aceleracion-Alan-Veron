package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.DTOS.PeliculaFiltersDTO;
import com.alkemy.disney.entities.GeneroEntity;
import com.alkemy.disney.entities.PeliculaEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class PeliculaSpecifications {

    public Specification<PeliculaEntity> getByFilters(PeliculaFiltersDTO filtersDTO) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicateList = new ArrayList<>();

            if (StringUtils.hasLength(filtersDTO.getTitulo())) {
                predicateList.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getTitulo().toLowerCase() + "%"
                        )
                );
            }


            if (!StringUtils.isEmpty(filtersDTO.getGeneroId())) {
                Join<PeliculaEntity, GeneroEntity> join = root.join("genero", JoinType.INNER);
                Expression<String> peliculasId = join.get("generoId");
                predicateList.add(peliculasId.in(filtersDTO.getGeneroId()));
            }

            // remover duplicados
            query.distinct(true);

            String orderByField = "fechaCreacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicateList.toArray(predicateList.toArray(new Predicate[0])));
        };
    }
}
