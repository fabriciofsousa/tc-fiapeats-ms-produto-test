package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ProdutoResponse;
import br.com.fiap.fiapeats.core.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoUseCasePort {
    ProdutoResponse criar(Produto produto);
    void editar(UUID id, Produto produto);
}
