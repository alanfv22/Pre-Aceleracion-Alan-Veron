package com.alkemy.disney.DTOS;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@ToString
public class PersonajeDTO {


    private Long personajeId;
    private String imagen;

    @NotBlank(message = "Debe asignar un nombre al personaje")
    private String nombre;

    private int edad;
    private float peso;
    private String historia;
    private Set<PeliculaDTO> peliculas;

}
