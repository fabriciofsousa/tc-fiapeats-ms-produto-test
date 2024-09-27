package br.com.fiap.fiapeats.domain.interfaces.out.categoria;

import br.com.fiap.fiapeats.domain.entities.Categoria;

public interface CategoriaRepositoryInterface {
  Categoria consultar(Categoria categoria);
}
