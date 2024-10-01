package br.com.fiap.fiapeats.usecases.interfaces.out.cliente;

import br.com.fiap.fiapeats.domain.entities.Cliente;

public interface ClienteRepositoryGateway {
    Cliente criar(Cliente cliente);

    Cliente identificar(String documento);
}
