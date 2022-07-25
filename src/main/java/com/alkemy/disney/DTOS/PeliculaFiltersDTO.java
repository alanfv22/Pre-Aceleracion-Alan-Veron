package com.alkemy.disney.DTOS;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class PeliculaFiltersDTO {

    String titulo;
    Long generoId;
    String order;

    public PeliculaFiltersDTO(String titulo, Long generoId, String order) {
        this.titulo = titulo;
        this.generoId = generoId;
        this.order = order;
    }

    public boolean isASC() { return this.order.compareToIgnoreCase("ASC")==0;}
    public boolean isDESC() { return this.order.compareToIgnoreCase("DESC")==0;}
}
