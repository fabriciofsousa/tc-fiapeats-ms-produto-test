package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.exceptions.NotFoundException;
import br.com.fiap.fiapeats.core.ports.in.IdentificarClienteUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;

public class IdentificarClienteUseCaseImpl implements IdentificarClienteUseCasePort {

    private final ClienteRepository clienteRepository;

    public IdentificarClienteUseCaseImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente identificar(String documento) {
        Cliente cliente = clienteRepository.identificar(documento);
        if (cliente == null) {
            throw new NotFoundException("A identificação do cliente falhou pois ele não existe!");
        }
        return cliente;
    }
}
