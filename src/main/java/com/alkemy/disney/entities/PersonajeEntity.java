package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "personaje_id")
    private Integer personajeId;

    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    private String imagen;

    @ManyToMany (fetch = FetchType.EAGER)  // Devuelve un personaje con sus peliculas correspondientes
    // duda sobre el cascade respecto a "Al momento del Update, solo actualizar la Entidad Personaje y no su listado de películas")
    @JoinTable(
            name = "personajes_peliculas",
            joinColumns = @JoinColumn(name = "personaje_Id", updatable = false), // updatable -> solo actualiza la Entidad Personaje y no su listado de películas?
            inverseJoinColumns = @JoinColumn(name = "pelicula_Id"))
    private Set<PeliculaEntity> peliculas;







}
