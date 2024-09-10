package br.com.fiap.fiapeats.interfaces.in.cliente;

import br.com.fiap.fiapeats.entities.Cliente;

public interface IdentificarClienteUseCaseInterface {
  Cliente identificar(String documento);
}
