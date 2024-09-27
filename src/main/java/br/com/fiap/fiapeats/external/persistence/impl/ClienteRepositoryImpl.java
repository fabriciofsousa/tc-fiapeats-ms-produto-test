package br.com.fiap.fiapeats.external.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ClienteRepository;
import br.com.fiap.fiapeats.external.persistence.mapper.ClienteEntityMapper;
import br.com.fiap.fiapeats.external.persistence.repository.ClienteRepositoryJPA;
import br.com.fiap.fiapeats.domain.entities.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteRepositoryImpl implements ClienteRepository {

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
