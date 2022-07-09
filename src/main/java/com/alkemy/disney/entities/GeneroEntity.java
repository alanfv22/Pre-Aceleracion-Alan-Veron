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
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "genero_id")
    private Integer generoId;

    private String nombre;
    private String imagen;

    @OneToMany (mappedBy = "genero", fetch = FetchType.EAGER, cascade = CascadeType.ALL) // Seteo  CascadeType.ALL ya que si borro un genero borro todas las peliculas relacionadas al genero
    private Set<PeliculaEntity> peliculas;

}
