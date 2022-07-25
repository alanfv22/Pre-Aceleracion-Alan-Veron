package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Setter
@Getter
public class PersonajeUpdateDTO {

    @NotNull(message = "Debe ingresar el ID del personaje a editar")
    private Long personajeId;

    private String imagen;

    @NotBlank(message = "El personaje no puede quedar sin nombre")
    private String nombre;

    private int edad;
    private float peso;
    private String historia;
}
