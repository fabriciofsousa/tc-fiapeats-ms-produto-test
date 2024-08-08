package br.com.fiap.fiapeats.core.ports.in.cliente;

import br.com.fiap.fiapeats.core.domain.Cliente;

public interface CriarClienteUseCasePort {
  Cliente criar(Cliente cliente);
}
