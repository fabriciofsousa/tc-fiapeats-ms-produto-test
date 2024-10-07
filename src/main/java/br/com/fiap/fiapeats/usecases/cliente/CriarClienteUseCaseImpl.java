package br.com.fiap.fiapeats.usecases.cliente;

import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.usecases.exceptions.ClienteExistenteException;
import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.usecases.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.cliente.ClienteRepositoryGateway;

public class CriarClienteUseCaseImpl implements CriarClienteUseCase {

    private final ClienteRepositoryGateway clienteRepositoryInterface;

    public CriarClienteUseCaseImpl(ClienteRepositoryGateway clienteRepositoryInterface) {
        this.clienteRepositoryInterface = clienteRepositoryInterface;
    }

    @Override
    public Cliente criar(CriarClienteDTO criarClienteDTO) {
        Cliente cliente = new Cliente(criarClienteDTO.getNome(), criarClienteDTO.getEmail(), criarClienteDTO.getDocumento());

        if (clienteRepositoryInterface.identificar(cliente.getDocumento()) != null) {
            throw new ClienteExistenteException("Cliente já possui cadastro");
        }
        return clienteRepositoryInterface.criar(cliente);
    }
}
