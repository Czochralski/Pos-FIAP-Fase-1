package com.czo.restaurantes_api.controller.handlers;

import com.czo.restaurantes_api.exceptions.RegistroDuplicadoException;
import com.czo.restaurantes_api.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ProblemDetail> handlerResourceNotFoundException(
            ResourceNotFoundException e) {

        var status = HttpStatus.NOT_FOUND;

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        status,
                        e.getMessage()
                );

        problemDetail.setTitle("Recurso não encontrado");

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<ProblemDetail> handlerRegistroDuplicadoException(
            RegistroDuplicadoException e) {

        var status = HttpStatus.CONFLICT;

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        status,
                        e.getMessage()
                );

        problemDetail.setTitle("Recurso em duplicidade");

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ProblemDetail> handlerMethodArgumentNotValid(
            MethodArgumentNotValidException e) {

        var status = HttpStatus.BAD_REQUEST;

        ProblemDetail problemDetail =
                ProblemDetail.forStatusAndDetail(
                        status,
                        "Existem campos inválidos na requisição"
                );

        problemDetail.setTitle("Erro de validação");

        Map<String, String> erros = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage
                ));

        problemDetail.setProperty("errors", erros);

        return ResponseEntity
                .status(status)
                .body(problemDetail);
    }
}
