package br.com.fiap.fiapeats.adapter.in.controller.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.produto.CriarProdutoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.produto.CriarProdutoResponse;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

  @Mapping(target = "id", ignore = true)
  Produto requestToDomain(CriarProdutoRequest criarProdutoRequest);

  CriarProdutoResponse domainToResponse(Produto produto);

  ProdutoEntity domainToEntity(Produto produto);

  Produto entityToDomain(ProdutoEntity produtoEntity);

}
