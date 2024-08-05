package br.com.fiap.fiapeats.adapter.in.controller.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CriarPedidoResponse;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.UUID;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idStatus", ignore = true)
  @Mapping(target = "dataHoraCriacao", ignore = true)
  @Mapping(target = "tempoEspera", ignore = true)
  @Mapping(target = "produtos", source = "idProdutos", qualifiedByName = "mapIdsToProdutos")
  Pedido toPedidoFromRequest(PedidoRequest pedidoRequest);

  @Mapping(target = "idPedido", source = "id")
  @Mapping(target = "status", source = "idStatus")
  CriarPedidoResponse toPedidoResponse(Pedido pedido);

  @Named("mapIdsToProdutos")
  static List<Produto> mapIdsToProdutos(List<UUID> ids) {
    return ids.stream().map(Produto::new).toList();
  }
}
