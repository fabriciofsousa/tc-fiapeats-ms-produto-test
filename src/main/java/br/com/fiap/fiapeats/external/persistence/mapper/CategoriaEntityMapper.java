package br.com.fiap.fiapeats.external.persistence.mapper;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.external.persistence.orm.CategoriaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {

  Categoria toCategoria(CategoriaEntity categoriaEntity);
}
