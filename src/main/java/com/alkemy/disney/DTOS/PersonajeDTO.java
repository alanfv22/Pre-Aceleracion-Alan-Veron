package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO {

    private Integer personajeId;
    private String imagen;
    private String nombre;
    private int edad;
    private int peso;
    private String historia;

}
