package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ClienteEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.ClienteRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteRepositoryImpl implements ClienteRepository {

  @Autowired private ClienteRepositoryJPA clienteRepositoryJPA;

  @Override
  public void criar(Cliente cliente) {
    clienteRepositoryJPA.save(
        new ClienteEntity(cliente.getDocumento(), cliente.getNome(), cliente.getEmail()));
  }
}
