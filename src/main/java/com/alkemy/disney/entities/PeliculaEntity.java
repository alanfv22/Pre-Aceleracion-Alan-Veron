package com.alkemy.disney.entities;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "peliculas")
@SQLDelete(sql = "UPDATE pelicula SET  deleted= true WHERE id=?")
@Where(clause = "deleted=false")
@Getter
@Setter
public class PeliculaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "pelicula_id")
    private Integer peliculaId;

    private String titulo;

    @Column (name = "fecha_creacion")
    @DateTimeFormat(pattern =  "yyyy/mm/dd")
    private LocalDate fechaCreacion;

    private String imagen;
    private int calificacion;

    private boolean deleted=  Boolean.FALSE;

    @ManyToMany (fetch = FetchType.LAZY,  cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "peliculas_personajes",
            joinColumns = @JoinColumn(name = "pelicula_Id"),
            inverseJoinColumns = @JoinColumn(name = "personaje_Id"))
    private Set<PersonajeEntity> personajes;

    @ManyToOne (fetch = FetchType.EAGER)//cascade = {CascadeType.PERSIST, CascadeType.MERGE}) no creamos genero cuando creamos pelicula
    @JoinColumn (name = "genero_id", insertable = false, updatable = false) // Solo para buscar informacion
    private GeneroEntity genero; // Para buscar informacion


    @Column(name = "genero_id",nullable=false) // Para guardar y actualizar,nullable=false->no permite null
    private Long generoId;

    // métodos de utilidad para el borrado y agregado de personajes

    public void agregarPersonaje (PersonajeEntity p){
        this.personajes.add(p);
        p.getPeliculas().add(this);
    }

    public void quitarPersonaje (PersonajeEntity p){
        this.personajes.remove(p);
        p.getPeliculas().remove(this);
    }







}
