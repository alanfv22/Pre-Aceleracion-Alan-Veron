package com.alkemy.disney.repository;

import com.alkemy.disney.entities.PeliculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long>, JpaSpecificationExecutor<PeliculaEntity> {

    Optional<PeliculaEntity> findByTitulo(String titulo);
}
