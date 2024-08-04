package br.com.fiap.fiapeats.adapter.in.exceptions;

import br.com.fiap.fiapeats.core.exceptions.CategoriaInvalida;
import br.com.fiap.fiapeats.core.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CategoriaInvalida.class)
  public ResponseEntity<Object> handle(CategoriaInvalida exception) {
    return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
  }

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> handle(NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }
}
