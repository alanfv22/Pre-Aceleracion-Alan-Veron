package com.alkemy.disney.auth.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
public class UserDTO {

    @Email(message = "El username debe ser un email")
    private String username;
    @Size(min = 8)
    private String password;
}
