package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.CategoriaRepository;
import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;

public class CategoriaRepositoryGatewayImpl implements CategoriaRepositoryGateway {

    private final CategoriaRepository categoriaRepository;

    public CategoriaRepositoryGatewayImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria consultar(Categoria categoria) {
        return categoriaRepository.consultar(categoria);
    }
}
