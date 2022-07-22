package com.alkemy.disney.controllers;

;
import com.alkemy.disney.DTOS.GeneroDTO;
import com.alkemy.disney.services.implementaciones.GeneroService;
import com.alkemy.disney.services.implementaciones.GeneroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("generos")
public class GeneroController {


    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDTO> save(@Valid @RequestBody GeneroDTO genero) {
        GeneroDTO generoGuardado = generoService.save(genero);
        return ResponseEntity.status(HttpStatus.CREATED).body(generoGuardado);
    }

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> getAll(){
        List <GeneroDTO> generos= generoService.getAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(generos);
    }
}
