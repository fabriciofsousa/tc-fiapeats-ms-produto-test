package br.com.fiap.fiapeats.external.api.mapper;

import br.com.fiap.fiapeats.external.persistence.orm.CategoriaEntity;
import br.com.fiap.fiapeats.domain.entities.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
  Categoria toCategoriaFromCategoriaEntity(CategoriaEntity categoriaEntity);
}
