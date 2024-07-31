package br.com.fiap.fiapeats.adapter.in.controller.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.PedidoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "idStatus", ignore = true)
  @Mapping(target = "dataCriacao", ignore = true)
  @Mapping(target = "tempoEspera", ignore = true)
  PedidoDTO toPedidoDTO(PedidoRequest pedidoRequest);

  @Mapping(target = "idPedido", source = "id")
  @Mapping(target = "status", ignore = true)
  PedidoResponse toPedidoResponse(PedidoDTO pedidoDTO);
}
