package com.alkemy.disney.DTOS;


import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class GeneroDTO {
    private Integer generoId;

    @NotBlank(message = "Debe ingresar un nombre")
    private String nombre;

    private String imagen;
}
