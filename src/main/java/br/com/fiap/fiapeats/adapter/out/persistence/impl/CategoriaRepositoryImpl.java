package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.repository.CategoriaRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CategoriaRepositoryImpl implements CategoriaRepositoryPort {

  private final CategoriaRepositoryJPA categoriaRepositoryJPA;

  public CategoriaRepositoryImpl(CategoriaRepositoryJPA categoriaRepositoryJPA) {
    this.categoriaRepositoryJPA = categoriaRepositoryJPA;
  }


  @Override
  public Categoria consultar(Categoria categoria) {
    var retorno = categoriaRepositoryJPA.findByDescricao(categoria.getDescricao());
    
  }
}
