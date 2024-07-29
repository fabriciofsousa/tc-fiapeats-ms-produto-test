package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Produto;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {
    ProdutoEntity criar(Produto produto);
    Optional<ProdutoEntity> consultar(UUID id);
    void editar(Produto produto);

}
