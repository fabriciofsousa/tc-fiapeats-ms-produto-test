package br.com.fiap.fiapeats.adapter.in.exceptions;

public class ClienteExistenteException extends RuntimeException {
    public ClienteExistenteException(String message) {
        super(message);
    }
}
