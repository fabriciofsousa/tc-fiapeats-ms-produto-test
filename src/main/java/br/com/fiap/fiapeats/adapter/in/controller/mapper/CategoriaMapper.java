package br.com.fiap.fiapeats.adapter.in.controller.mapper;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.CategoriaEntity;
import br.com.fiap.fiapeats.core.domain.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
  Categoria toCategoriaFromCategoriaEntity(CategoriaEntity categoriaEntity);
}
