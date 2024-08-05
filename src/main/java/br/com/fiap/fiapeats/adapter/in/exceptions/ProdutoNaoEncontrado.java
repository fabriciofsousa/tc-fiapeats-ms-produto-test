package br.com.fiap.fiapeats.adapter.in.Exception;

public class ProdutoNaoEncontrado extends RuntimeException {

    public ProdutoNaoEncontrado(String message) {
        super(message);
    }
}
