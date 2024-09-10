package br.com.fiap.fiapeats.adapter.controller.mapper;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.CategoriaEntity;
import br.com.fiap.fiapeats.entities.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
  Categoria toCategoriaFromCategoriaEntity(CategoriaEntity categoriaEntity);
}
