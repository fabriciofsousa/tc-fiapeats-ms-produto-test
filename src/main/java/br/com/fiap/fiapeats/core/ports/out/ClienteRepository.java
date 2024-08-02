package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Cliente;

public interface ClienteRepository {
  Cliente criar(Cliente cliente);
  Cliente identificar(String documento);
}
