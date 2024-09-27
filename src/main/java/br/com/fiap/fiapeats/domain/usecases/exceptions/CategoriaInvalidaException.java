package br.com.fiap.fiapeats.domain.usecases.exceptions;

public class CategoriaInvalidaException extends RuntimeException {

  public CategoriaInvalidaException(String message) {
    super(message);
  }
}
