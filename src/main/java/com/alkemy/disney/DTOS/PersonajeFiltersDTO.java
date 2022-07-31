package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeFiltersDTO {

    String nombre;
    int edad;
    Set<Long> peliculas;
    private float peso;

    public PersonajeFiltersDTO(String nombre, Integer edad, Set<Long> peliculas, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peliculas = peliculas;
        this.peso = peso;
    }

}
