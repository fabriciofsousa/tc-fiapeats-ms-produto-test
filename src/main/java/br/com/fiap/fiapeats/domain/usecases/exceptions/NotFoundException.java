package br.com.fiap.fiapeats.domain.usecases.exceptions;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
