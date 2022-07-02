package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "genero")
@Getter
@Setter
public class GeneroEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "genero_id")
    private Integer generoId;

    private String nombre;
    private String imagen;

    @OneToMany (mappedBy = "genero", fetch = FetchType.EAGER )
    private Set<PeliculaEntity> peliculas;

}
