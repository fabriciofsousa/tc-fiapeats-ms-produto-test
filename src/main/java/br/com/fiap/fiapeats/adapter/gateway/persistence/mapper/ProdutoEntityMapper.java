package br.com.fiap.fiapeats.adapter.gateway.persistence.mapper;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.ProdutoEntity;
import br.com.fiap.fiapeats.entities.Categoria;
import br.com.fiap.fiapeats.entities.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

  ProdutoEntity toProdutoEntity(Produto produto);

  default Produto toProduto(ProdutoEntity produtoEntity) {
    return new Produto(
        produtoEntity.getId(),
        produtoEntity.getNome(),
        produtoEntity.getDescricao(),
        produtoEntity.getValor(),
        new Categoria(
            produtoEntity.getCategoria().getId(), produtoEntity.getCategoria().getDescricao()),
        produtoEntity.getImagemUrl());
  }
}
