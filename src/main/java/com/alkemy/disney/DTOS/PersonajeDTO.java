package com.alkemy.disney.DTOS;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class PersonajeDTO {

    private Long personajeId;
    private String imagen;

    @NotNull
    private String nombre;


    private int edad;
    private float peso;

    @NotNull
    private String historia;


    private Set<PeliculaDTO> peliculas;

}
