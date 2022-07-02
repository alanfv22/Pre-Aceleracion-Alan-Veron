package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer personajeID;

    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    private String imagen;

    @ManyToMany
    private List<PeliculaEntity> peliculas;

    /*@JoinTable(
    con este codigo se puede setear el nombre de la tabla

            name = "personaje-peliculas",
            joinColumns = @JoinColumn(name = "personajeID"),
            inverseJoinColumns = @JoinColumn(name = "peliculaID"))*/





}
