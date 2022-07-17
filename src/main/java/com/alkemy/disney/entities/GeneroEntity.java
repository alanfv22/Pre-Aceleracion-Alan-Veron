package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "generos")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "genero_id")
    private Integer generoId;

    private String nombre;
    private String imagen;

    //esto no hace falta
    @OneToMany (mappedBy = "genero", fetch = FetchType.LAZY, cascade = CascadeType.ALL) // Seteo  CascadeType.ALL ya que si borro un genero borro todas las peliculas relacionadas al genero
    private Set<PeliculaEntity> peliculas;

}
