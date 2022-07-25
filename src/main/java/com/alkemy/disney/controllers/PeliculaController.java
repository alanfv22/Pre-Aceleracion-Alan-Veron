package com.alkemy.disney.controllers;


import com.alkemy.disney.DTOS.PeliculaBasicDTO;
import com.alkemy.disney.DTOS.PeliculaDTO;
import com.alkemy.disney.DTOS.PeliculaUpdateDTO;
import com.alkemy.disney.DTOS.PersonajeDTO;
import com.alkemy.disney.services.Interfaces.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("movies")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    public ResponseEntity<PeliculaDTO> save(@Valid  @RequestBody PeliculaDTO pelicula){
        PeliculaDTO peliculaGuardado =peliculaService.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardado);

    }
   @GetMapping
    public ResponseEntity<List<PeliculaBasicDTO>> getDetailByFilters(
            @RequestParam(required = false)String titulo,
            @RequestParam(required = false) Long generoId,
            @RequestParam(required = false, defaultValue = "ASC") String order
            ) {
        List<PeliculaBasicDTO> peliculas= peliculaService.getByFilters(titulo,generoId,order);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculas);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PeliculaDTO> getCharacterById(@PathVariable Long id){
        PeliculaDTO pelicula= peliculaService.getById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }
    @PutMapping
    public ResponseEntity<PeliculaDTO> update(@Valid @RequestBody PeliculaUpdateDTO pelicula) {
        PeliculaDTO peliculaGuardado =peliculaService.update(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(peliculaGuardado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        peliculaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Boolean> agregarPersonaje(@PathVariable Long idMovie,@PathVariable Long idCharacter) {
        peliculaService.addCharacter(idMovie,idCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{idMovie}/characters/{idCharacter}")
    public ResponseEntity<Boolean> borrarPersonaje(@PathVariable Long idMovie,@PathVariable Long idCharacter) {
        peliculaService.deleteCharacter(idMovie,idCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }



}
