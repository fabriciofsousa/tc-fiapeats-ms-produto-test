package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ClienteRepository;
import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.usecases.interfaces.out.cliente.ClienteRepositoryGateway;

public class ClienteRepositoryGatewayImpl implements ClienteRepositoryGateway {

    private final ClienteRepository clienteRepository;

    public ClienteRepositoryGatewayImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        return clienteRepository.criar(cliente);
    }

    @Override
    public Cliente identificar(String documento) {
        return clienteRepository.identificar(documento);
    }
}
