package br.com.fiap.fiapeats.adapter.in.controller.mapper;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CriarClienteRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CriarClienteResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.IdentificarClienteResponse;
import br.com.fiap.fiapeats.core.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    IdentificarClienteResponse toIdentificarClienteResponse(Cliente cliente);

    CriarClienteResponse toCriarClienteResponse(Cliente cliente);

    Cliente toCliente(CriarClienteRequest criarClienteRequest);

}
