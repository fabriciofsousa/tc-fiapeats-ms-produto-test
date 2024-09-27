package br.com.fiap.fiapeats.domain.usecases.exceptions;

public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String message) {
        super(message);
    }
}
