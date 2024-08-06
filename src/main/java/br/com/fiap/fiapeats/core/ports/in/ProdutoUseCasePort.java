package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Produto;
import java.util.UUID;

public interface ProdutoUseCasePort {
  Produto criar(Produto produto);

  Produto editar(UUID id, Produto produto);

  void excluir(UUID id);
}
