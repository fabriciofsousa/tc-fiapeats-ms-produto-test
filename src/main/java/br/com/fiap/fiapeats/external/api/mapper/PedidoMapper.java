package br.com.fiap.fiapeats.external.api.mapper;

import br.com.fiap.fiapeats.external.api.contracts.request.CriarPedidoRequest;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
  CriarPedidoDTO toCriarPedidoDTO(CriarPedidoRequest request);
}
