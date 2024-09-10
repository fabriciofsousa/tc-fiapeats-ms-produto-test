package br.com.fiap.fiapeats.usecases.cliente;

import br.com.fiap.fiapeats.entities.Cliente;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.interfaces.in.cliente.IdentificarClienteUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.cliente.ClienteRepositoryInterface;

public class IdentificarClienteUseCaseImpl implements IdentificarClienteUseCaseInterface {

  private final ClienteRepositoryInterface clienteRepositoryInterface;

  public IdentificarClienteUseCaseImpl(ClienteRepositoryInterface clienteRepositoryInterface) {
    this.clienteRepositoryInterface = clienteRepositoryInterface;
  }

  @Override
  public Cliente identificar(String documento) {
    Cliente cliente = clienteRepositoryInterface.identificar(documento);
    if (cliente == null) {
      throw new NotFoundException("A identificação do cliente falhou pois ele não existe!");
    }
    return cliente;
  }
}
