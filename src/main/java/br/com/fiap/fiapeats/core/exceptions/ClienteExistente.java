package br.com.fiap.fiapeats.core.exceptions;

public class ClienteExistente extends RuntimeException {

  public ClienteExistente(String message) {
    super(message);
  }
}
