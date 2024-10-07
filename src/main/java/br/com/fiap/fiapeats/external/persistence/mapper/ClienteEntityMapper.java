package br.com.fiap.fiapeats.external.persistence.mapper;

import br.com.fiap.fiapeats.external.persistence.orm.ClienteEntity;
import br.com.fiap.fiapeats.domain.entities.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

  Cliente toCliente(ClienteEntity clienteEntity);

  ClienteEntity toClienteEntity(Cliente cliente);
}
