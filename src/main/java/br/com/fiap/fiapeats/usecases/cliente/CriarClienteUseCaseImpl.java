package br.com.fiap.fiapeats.usecases.cliente;

import br.com.fiap.fiapeats.usecases.exceptions.ClienteExistenteException;
import br.com.fiap.fiapeats.entities.Cliente;
import br.com.fiap.fiapeats.interfaces.in.cliente.CriarClienteUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.ClienteRepositoryInterface;

public class CriarClienteUseCaseImpl implements CriarClienteUseCaseInterface {

    private final ClienteRepositoryInterface clienteRepositoryInterface;

    public CriarClienteUseCaseImpl(ClienteRepositoryInterface clienteRepositoryInterface) {
        this.clienteRepositoryInterface = clienteRepositoryInterface;
    }

    @Override
    public Cliente criar(Cliente cliente) {
        if (clienteRepositoryInterface.identificar(cliente.getDocumento()) != null) {
            throw new ClienteExistenteException("Cliente já possui cadastro");
        }
        return clienteRepositoryInterface.criar(cliente);
    }
}
