package br.com.fiap.fiapeats.adapter.out.persistence.mapper;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ClienteEntity;
import br.com.fiap.fiapeats.core.domain.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    Cliente toCliente(ClienteEntity clienteEntity);

    ClienteEntity toClienteEntity(Cliente cliente);

}
