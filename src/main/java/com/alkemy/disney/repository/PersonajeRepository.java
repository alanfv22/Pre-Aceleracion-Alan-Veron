package com.alkemy.disney.repository;


import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long>, JpaSpecificationExecutor<PersonajeEntity> {


    Optional<PersonajeEntity> findByNombre(String nombre);
}
