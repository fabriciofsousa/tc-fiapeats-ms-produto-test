package br.com.fiap.fiapeats.adapter.out.persistence.mapper;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.CategoriaEntity;
import br.com.fiap.fiapeats.core.domain.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaEntityMapper {

  Categoria toCategoria(CategoriaEntity categoriaEntity);

  //    default Categoria toCategoria(CategoriaEntity categoriaEntity){
  //        return new Categoria(categoriaEntity.getId(), categoriaEntity.getDescricao());
  //    }
}
