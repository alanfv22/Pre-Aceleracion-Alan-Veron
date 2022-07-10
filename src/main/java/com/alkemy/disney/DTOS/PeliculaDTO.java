package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class PeliculaDTO {

    private Integer peliculaId;
    private String imagen;
    private String titulo;
    private LocalDate fechaCreacion;
    private int calificacion;

}
