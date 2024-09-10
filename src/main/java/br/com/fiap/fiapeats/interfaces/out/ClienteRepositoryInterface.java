package br.com.fiap.fiapeats.interfaces.out;

import br.com.fiap.fiapeats.entities.Cliente;

public interface ClienteRepositoryInterface {
  Cliente criar(Cliente cliente);

  Cliente identificar(String documento);
}
