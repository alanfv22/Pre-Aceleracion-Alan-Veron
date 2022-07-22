package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class PersonajeBasicDTO { // clase para updatear personaje

    private Long personajeId;
    private String imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;
}
