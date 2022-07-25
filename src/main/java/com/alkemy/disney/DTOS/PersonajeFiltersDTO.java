package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class PersonajeFiltersDTO {

    String nombre;
    Integer edad;
    Set<Long> peliculas;

    public PersonajeFiltersDTO(String nombre, Integer edad, Set<Long> peliculas) {
        this.nombre = nombre;
        this.edad = edad;
        this.peliculas = peliculas;
    }

}
