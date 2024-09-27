package br.com.fiap.fiapeats.external.api.mapper;

import br.com.fiap.fiapeats.domain.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarPedidoRequest;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PedidoMapper {
    CriarPedidoDTO toCriarPedidoDTO(CriarPedidoRequest request);
}
