package com.alkemy.disney.DTOS;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ApiErrorDTO {

    HttpStatus status;
    String message;
    List<String> errors;

    public ApiErrorDTO(HttpStatus status, String message, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}
