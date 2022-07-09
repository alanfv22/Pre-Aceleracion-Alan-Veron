package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "personajes")
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

    @ManyToMany (fetch = FetchType.LAZY)// duda sobre el cascade respecto a "Al momento del Update, solo actualizar la Entidad Personaje y no su listado de películas")
    @JoinTable(
            name = "personajes_peliculas",
            joinColumns = @JoinColumn(name = "personaje_Id", updatable = false), // ¿updatable ≥ solo actualiza la Entidad Personaje y no su listado de películas?
            inverseJoinColumns = @JoinColumn(name = "pelicula_Id"))
    private Set<PeliculaEntity> peliculas;

    // métodos de utilidad para el borrado y agregado de peliculas

    public void agregarPelicula (PeliculaEntity p){
        this.peliculas.add(p);
        p.getPersonajes().add(this);
    }

    public void quitarPelicula (PeliculaEntity p){
        this.peliculas.remove(p);
        p.getPersonajes().remove(this);
    }








}
