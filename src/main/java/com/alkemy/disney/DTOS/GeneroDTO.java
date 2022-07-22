package com.alkemy.disney.DTOS;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneroDTO {
    private Integer generoId;

    @NotNull
    private String nombre;

    private String imagen;
}
