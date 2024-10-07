package br.com.fiap.fiapeats.external.persistence.mapper;

import br.com.fiap.fiapeats.external.persistence.orm.CategoriaEntity;
import br.com.fiap.fiapeats.domain.entities.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {

  Categoria toCategoria(CategoriaEntity categoriaEntity);
}
