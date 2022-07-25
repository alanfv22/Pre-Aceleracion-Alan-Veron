package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class PeliculaUpdateDTO {

    @NotNull(message = "Debe ingresar el ID de la pelicula a editar")
    private Long peliculaId;
    private String imagen;

    @NotBlank(message = "Debe ingresar el titulo")
    private String titulo;

    private LocalDate fechaCreacion;

    @Min(1)
    @Max(10)
    private int calificacion;

    private Long generoId;

}
