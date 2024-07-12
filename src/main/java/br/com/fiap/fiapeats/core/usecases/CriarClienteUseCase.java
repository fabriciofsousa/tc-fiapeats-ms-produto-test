package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.ports.in.CriarClienteUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarClienteUseCase implements CriarClienteUseCasePort {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void criar(Cliente cliente) {
        clienteRepository.criar(cliente);
    }
}
