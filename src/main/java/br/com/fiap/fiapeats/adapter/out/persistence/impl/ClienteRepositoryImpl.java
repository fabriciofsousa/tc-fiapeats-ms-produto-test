package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.mapper.ClienteEntityMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.ClienteRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private ClienteRepositoryJPA clienteRepositoryJPA;

    @Autowired
    private ClienteEntityMapper clienteEntityMapper;

    @Override
    public Cliente criar(Cliente cliente) {
        return clienteEntityMapper.toCliente(clienteRepositoryJPA.save(clienteEntityMapper.toClienteEntity(cliente)));
    }

    @Override
    public Cliente identificar(String documento) {
        return clienteRepositoryJPA.findById(documento)
                .map(clienteEntityMapper::toCliente)
                .orElse(null);
    }


}
