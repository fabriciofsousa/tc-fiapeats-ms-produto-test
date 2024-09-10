package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.mapper.ClienteEntityMapper;
import br.com.fiap.fiapeats.adapter.gateway.persistence.repository.ClienteRepositoryJPA;
import br.com.fiap.fiapeats.entities.Cliente;
import br.com.fiap.fiapeats.interfaces.out.cliente.ClienteRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteRepositoryInterfaceImpl implements ClienteRepositoryInterface {

  @Autowired private ClienteRepositoryJPA clienteRepositoryJPA;

  @Autowired private ClienteEntityMapper clienteEntityMapper;

  @Override
  public Cliente criar(Cliente cliente) {
    return clienteEntityMapper.toCliente(
        clienteRepositoryJPA.save(clienteEntityMapper.toClienteEntity(cliente)));
  }

  @Override
  public Cliente identificar(String documento) {
    return clienteRepositoryJPA
        .findById(documento)
        .map(clienteEntityMapper::toCliente)
        .orElse(null);
  }
}
