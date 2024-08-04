package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Produto;

public interface CriarProdutoUseCasePort {
  Produto criar(Produto produto);
}
