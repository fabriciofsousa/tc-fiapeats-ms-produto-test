package br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces;

import br.com.fiap.fiapeats.domain.entities.Cliente;

public interface ClienteRepository {
    Cliente criar(Cliente cliente);

    Cliente identificar(String documento);
}
