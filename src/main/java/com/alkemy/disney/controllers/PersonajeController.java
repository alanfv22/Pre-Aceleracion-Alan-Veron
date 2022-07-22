package com.alkemy.disney.controllers;


import com.alkemy.disney.DTOS.PersonajeBasicDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.services.implementaciones.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;

    @PostMapping
    public ResponseEntity<PersonajeDTO> save(@Valid @RequestBody PersonajeDTO personaje) {
        PersonajeDTO personajeGuardado =personajeService.save(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }

    @GetMapping
    public ResponseEntity<Set<PersonajeDTO>> getAll(){
        Set<PersonajeDTO> personajes= personajeService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(personajes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDTO> getCharacterById(@PathVariable Long id){
        PersonajeDTO personaje= personajeService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(personaje);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        personajeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping
    public ResponseEntity<PersonajeDTO> update(@Valid @RequestBody PersonajeBasicDTO personaje) {
        PersonajeDTO personajeGuardado =personajeService.update(personaje);
        return ResponseEntity.status(HttpStatus.CREATED).body(personajeGuardado);
    }




}
