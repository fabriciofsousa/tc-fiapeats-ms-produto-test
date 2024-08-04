package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.ports.in.CriarClienteUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;

public class CriarClienteUseCaseImpl implements CriarClienteUseCasePort {

  private final ClienteRepository clienteRepository;

  public CriarClienteUseCaseImpl(ClienteRepository clienteRepository) {
    this.clienteRepository = clienteRepository;
  }

  @Override
  public void criar(Cliente cliente) {
    clienteRepository.criar(cliente);
  }
}
