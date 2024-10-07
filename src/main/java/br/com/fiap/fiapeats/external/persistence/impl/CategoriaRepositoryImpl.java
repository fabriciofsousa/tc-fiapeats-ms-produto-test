package br.com.fiap.fiapeats.external.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.CategoriaRepository;
import br.com.fiap.fiapeats.external.persistence.mapper.CategoriaEntityMapper;
import br.com.fiap.fiapeats.external.persistence.repository.CategoriaRepositoryJPA;
import br.com.fiap.fiapeats.domain.entities.Categoria;
import org.springframework.stereotype.Component;

@Component
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final CategoriaEntityMapper categoriaEntityMapper;

    private final CategoriaRepositoryJPA categoriaRepositoryJPA;

    public CategoriaRepositoryImpl(
            CategoriaRepositoryJPA categoriaRepositoryJPA, CategoriaEntityMapper categoriaEntityMapper) {
        this.categoriaEntityMapper = categoriaEntityMapper;
        this.categoriaRepositoryJPA = categoriaRepositoryJPA;
    }

    @Override
    public Categoria consultar(Categoria categoria) {
        return categoriaRepositoryJPA
                .findByDescricao(categoria.getDescricao())
                .map(categoriaEntityMapper::toCategoria)
                .orElse(null);
    }
}
