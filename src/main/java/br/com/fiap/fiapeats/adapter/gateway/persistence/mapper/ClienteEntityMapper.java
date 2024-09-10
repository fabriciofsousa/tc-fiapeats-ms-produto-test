package br.com.fiap.fiapeats.adapter.gateway.persistence.mapper;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.ClienteEntity;
import br.com.fiap.fiapeats.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

  Cliente toCliente(ClienteEntity clienteEntity);

  ClienteEntity toClienteEntity(Cliente cliente);
}
