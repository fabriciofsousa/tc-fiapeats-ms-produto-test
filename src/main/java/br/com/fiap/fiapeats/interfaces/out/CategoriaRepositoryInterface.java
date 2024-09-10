package br.com.fiap.fiapeats.interfaces.out;

import br.com.fiap.fiapeats.entities.Categoria;

public interface CategoriaRepositoryInterface {
  Categoria consultar(Categoria categoria);
}
