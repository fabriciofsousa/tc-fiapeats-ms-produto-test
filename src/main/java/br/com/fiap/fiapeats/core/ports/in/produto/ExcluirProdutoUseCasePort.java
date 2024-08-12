package br.com.fiap.fiapeats.core.ports.in.produto;

import java.util.UUID;

public interface ExcluirProdutoUseCasePort {
  void excluir(UUID id);
}
