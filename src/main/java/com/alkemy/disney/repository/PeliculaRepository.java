package com.alkemy.disney.repository;

import com.alkemy.disney.entities.PeliculaEntity;
import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PeliculaRepository extends JpaRepository  <PeliculaEntity,Long>, JpaSpecificationExecutor<PeliculaEntity> {

  //  Set<PeliculaEntity> findAll(Specification<PeliculaEntity> spec);

    Optional<PersonajeEntity> findByTitulo(String titulo);
}
