package br.com.fiap.fiapeats.adapter.gateway.persistence.mapper;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.CategoriaEntity;
import br.com.fiap.fiapeats.entities.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {

  Categoria toCategoria(CategoriaEntity categoriaEntity);
}
