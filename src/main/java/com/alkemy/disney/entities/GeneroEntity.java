package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "generos")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genero_id")
    private Integer generoId;

    private String nombre;
    private String imagen;

    //esto no hace falta
    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private Set<PeliculaEntity> peliculas;

}
