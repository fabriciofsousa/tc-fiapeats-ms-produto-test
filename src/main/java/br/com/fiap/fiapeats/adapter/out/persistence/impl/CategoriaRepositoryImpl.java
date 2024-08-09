package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.mapper.CategoriaEntityMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.CategoriaRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class CategoriaRepositoryImpl implements CategoriaRepositoryPort {

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
