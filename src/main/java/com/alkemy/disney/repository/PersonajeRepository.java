package com.alkemy.disney.repository;


import com.alkemy.disney.entities.PersonajeEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonajeRepository extends CrudRepository<PersonajeEntity, Integer> {

    //List<PersonajeEntity> findByPersonajeReference(String personaje);

    List <PersonajeEntity> findById(int id);


}
