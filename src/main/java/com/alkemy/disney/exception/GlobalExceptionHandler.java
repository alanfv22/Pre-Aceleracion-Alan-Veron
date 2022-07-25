package com.alkemy.disney.exception;

import com.alkemy.disney.DTOS.ApiErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ParamNotFound.class})
    protected ResponseEntity<Object> handleParamNotFound(RuntimeException ex, WebRequest request){
        ApiErrorDTO errorDTO = new ApiErrorDTO(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                Arrays.asList("Param Not Found")

        );
    return handleExceptionInternal(ex,errorDTO,new HttpHeaders(),HttpStatus.BAD_REQUEST,request);

    }
//manejo de valid
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        Map<String, List<String>> body = new HashMap<>();

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        body.put("errors", errors);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value={IllegalArgumentException.class, IllegalStateException.class})
    public ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request){
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex,bodyOfResponse,new HttpHeaders(),HttpStatus.CONFLICT,request);
    }

}


