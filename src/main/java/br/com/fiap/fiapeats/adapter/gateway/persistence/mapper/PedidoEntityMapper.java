package br.com.fiap.fiapeats.adapter.gateway.persistence.mapper;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.PedidoEntity;
import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.ProdutoEntity;
import br.com.fiap.fiapeats.entities.Categoria;
import br.com.fiap.fiapeats.entities.Pedido;
import br.com.fiap.fiapeats.entities.Produto;
import java.util.List;
import java.util.Set;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {

  PedidoEntity toPedidoEntity(Pedido pedido);

  @Mapping(
      target = "produtos",
      source = "produtos",
      qualifiedByName = "mapProdutoEntitiesToProdutos")
  Pedido toPedidoFromEntity(PedidoEntity pedidoEntity);

  List<Pedido> toListaPedidos(List<PedidoEntity> pedidos);

  @Named("mapProdutoEntitiesToProdutos")
  static List<Produto> mapProdutoEntitiesToProdutos(Set<ProdutoEntity> produtoEntities) {
    return produtoEntities.stream()
        .map(
            entity ->
                new Produto(
                    entity.getId(),
                    entity.getNome(),
                    entity.getDescricao(),
                    entity.getValor(),
                    entity.getCategoria() != null
                        ? new Categoria(
                            entity.getCategoria().getId(), entity.getCategoria().getDescricao())
                        : null,
                    entity.getImagemUrl()))
        .toList();
  }
}
