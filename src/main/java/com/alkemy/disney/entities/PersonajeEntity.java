package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "personajes")
@SQLDelete(sql = "UPDATE personajes SET  deleted= true WHERE personaje_id=?")
@Where(clause = "deleted=false")
@Getter
@Setter
public class PersonajeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "personaje_id")
    private Long personajeId;

    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    private String imagen;
    private boolean deleted=  Boolean.FALSE;

    @ManyToMany(mappedBy = "personajes", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
