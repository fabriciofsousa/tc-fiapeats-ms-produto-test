package br.com.fiap.fiapeats.domain.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;

public interface CriarProdutoUseCase {
  Produto criar(Produto produto);
}
