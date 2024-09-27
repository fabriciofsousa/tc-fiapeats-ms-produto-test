package br.com.fiap.fiapeats.domain.interfaces.in.cliente;

import br.com.fiap.fiapeats.domain.entities.Cliente;

public interface IdentificarClienteUseCase {
  Cliente identificar(String documento);
}
