package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer peliculaID;

    private String titulo;
    private Date FechaCreacion;
    private String imagen;
    private int calificacion;

    @ManyToMany
    private List<PersonajeEntity> personajes;

}
