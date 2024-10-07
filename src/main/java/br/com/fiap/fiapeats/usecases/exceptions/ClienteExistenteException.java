package br.com.fiap.fiapeats.usecases.exceptions;

public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String message) {
        super(message);
    }
}
