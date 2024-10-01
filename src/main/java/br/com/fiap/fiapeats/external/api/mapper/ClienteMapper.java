package br.com.fiap.fiapeats.external.api.mapper;

import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarClienteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    CriarClienteDTO toCriarClienteDTO(CriarClienteRequest criarClienteRequest);
}
