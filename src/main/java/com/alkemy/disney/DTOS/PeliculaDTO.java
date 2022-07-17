package com.alkemy.disney.DTOS;

import com.alkemy.disney.entities.PersonajeEntity;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PeliculaDTO {

    private Integer peliculaId;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;

    private int calificacion;
    private Long generoId;
    private Set<PersonajeEntity> personajes;
}

