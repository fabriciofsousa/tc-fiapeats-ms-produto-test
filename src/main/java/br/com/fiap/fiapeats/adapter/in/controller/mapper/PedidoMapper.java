package br.com.fiap.fiapeats.adapter.in.controller.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import br.com.fiap.fiapeats.core.domain.Pedido;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idStatus", ignore = true)
  @Mapping(target = "dataHoraCriacao", ignore = true)
  @Mapping(target = "tempoEspera", ignore = true)
  Pedido toPedido(PedidoRequest pedidoRequest);

  @Mapping(target = "idPedido", source = "id")
  @Mapping(target = "status", source = "idStatus")
  PedidoResponse toPedidoResponse(Pedido pedido);

  PedidoEntity toPedidoEntity(Pedido pedido);

  @Mapping(target = "idProdutos", ignore = true)
  Pedido toPedido(PedidoEntity pedidoEntity);
}
