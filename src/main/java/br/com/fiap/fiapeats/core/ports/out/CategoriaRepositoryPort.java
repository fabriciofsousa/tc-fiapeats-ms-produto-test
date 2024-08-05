package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Categoria;

public interface CategoriaRepositoryPort {
  Categoria consultar(Categoria categoria);
}
