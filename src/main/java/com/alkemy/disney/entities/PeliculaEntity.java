package com.alkemy.disney.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "pelicula_id")
    private Integer peliculaId;

    private String titulo;

    @Column (name = "fecha_creacion")
    @DateTimeFormat(pattern =  "yyyy/mm/dd")
    private LocalDate fechaCreacion;

    private String imagen;
    private int calificacion;

    @ManyToMany(mappedBy = "peliculas",
                fetch = FetchType.EAGER, // Devuelve una pelicula con sus personajes correspondientes
                cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
                    }
                 )
    private Set<PersonajeEntity> personajes;

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn (name = "genero_id", insertable = false, updatable = false) // Solo para buscar informacion
    private GeneroEntity genero; // Para buscar informacion

    @Column(name = "genero_id", nullable = false) // Para guardar y actualizar
    private Long generoId;








}
