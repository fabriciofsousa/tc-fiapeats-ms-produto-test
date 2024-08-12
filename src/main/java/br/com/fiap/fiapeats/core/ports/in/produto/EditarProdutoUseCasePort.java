package br.com.fiap.fiapeats.core.ports.in.produto;

import br.com.fiap.fiapeats.core.domain.Produto;

public interface EditarProdutoUseCasePort {
  Produto editar(Produto produto);
}
