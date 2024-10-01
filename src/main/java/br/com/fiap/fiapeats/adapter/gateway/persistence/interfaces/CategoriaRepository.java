package br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces;

import br.com.fiap.fiapeats.domain.entities.Categoria;

public interface CategoriaRepository {
    Categoria consultar(Categoria categoria);
}
