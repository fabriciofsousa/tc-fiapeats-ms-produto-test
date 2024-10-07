package br.com.fiap.fiapeats.usecases.exceptions;

public class CategoriaInvalidaException extends RuntimeException {

  public CategoriaInvalidaException(String message) {
    super(message);
  }
}
