package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Produto;

import java.util.Optional;

public interface ProdutoRepository {
    ProdutoEntity criar(Produto produto);
    Optional<ProdutoEntity> consultar(Long id);
}
