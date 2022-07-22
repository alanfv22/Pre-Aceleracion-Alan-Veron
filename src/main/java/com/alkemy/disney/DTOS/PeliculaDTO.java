package com.alkemy.disney.DTOS;



import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {

    private Integer peliculaId;
    private String imagen;

    @NotNull(message = "Debe ingresar el titulo")
    private String titulo;

    private LocalDate fechaCreacion;

    @Min(1)
    @Max(10)
    private int calificacion;

    private Long generoId;

    @NotNull(message = "La pelicula debe contener personajes")
    private Set<PersonajeDTO> personajes;
}

