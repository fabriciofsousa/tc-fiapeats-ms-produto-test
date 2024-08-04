package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Produto;

public interface EditarProdutoUseCasePort {
  Produto editar(Produto produto);
}
