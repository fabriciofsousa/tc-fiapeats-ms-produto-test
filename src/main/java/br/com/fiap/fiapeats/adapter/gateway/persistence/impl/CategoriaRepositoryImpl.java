package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.mapper.CategoriaEntityMapper;
import br.com.fiap.fiapeats.adapter.gateway.persistence.repository.CategoriaRepositoryJPA;
import br.com.fiap.fiapeats.entities.Categoria;
import br.com.fiap.fiapeats.interfaces.out.CategoriaRepositoryInterface;
import org.springframework.stereotype.Component;

@Component
public class CategoriaRepositoryImpl implements CategoriaRepositoryInterface {

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
