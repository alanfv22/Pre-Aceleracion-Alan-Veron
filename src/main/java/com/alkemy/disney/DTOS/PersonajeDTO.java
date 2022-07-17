package com.alkemy.disney.DTOS;


import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PersonajeDTO {

    private Long personajeId;
    private String imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    private Set<PeliculaDTO> peliculas;

}
