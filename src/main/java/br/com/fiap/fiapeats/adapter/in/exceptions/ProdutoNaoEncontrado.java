package br.com.fiap.fiapeats.adapter.in.exceptions;

public class ProdutoNaoEncontrado extends RuntimeException {

    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
}
