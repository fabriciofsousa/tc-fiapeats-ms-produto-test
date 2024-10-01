package br.com.fiap.fiapeats.usecases.interfaces.out.categoria;

import br.com.fiap.fiapeats.domain.entities.Categoria;

public interface CategoriaRepositoryGateway {
    Categoria consultar(Categoria categoria);
}
