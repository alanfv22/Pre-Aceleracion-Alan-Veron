package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PeliculaBasicDTO {

    String imagen;
    String titulo;
    LocalDate fechaCreación;
}
