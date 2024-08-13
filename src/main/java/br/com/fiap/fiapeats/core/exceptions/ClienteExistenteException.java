package br.com.fiap.fiapeats.core.exceptions;

public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String message) {
        super(message);
    }
}
