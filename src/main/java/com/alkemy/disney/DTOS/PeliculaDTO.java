package com.alkemy.disney.DTOS;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@ToString
public class PeliculaDTO {

    private Long peliculaId;
    private String imagen;

    @NotBlank(message = "Debe ingresar el titulo")
    private String titulo;

    private LocalDate fechaCreacion;

    @Min(1)
    @Max(10)
    private int calificacion;

    @NotNull(message = "Debe asignar un genero")
    private Long generoId;

    @NotNull(message = "La pelicula debe contener personajes")
    private Set<PersonajeDTO> personajes;
}

