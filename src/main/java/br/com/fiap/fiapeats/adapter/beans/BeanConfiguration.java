package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.core.ports.in.CriarClienteUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.IdentificarClienteUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;
import br.com.fiap.fiapeats.core.usecases.CriarClienteUseCaseImpl;
import br.com.fiap.fiapeats.core.usecases.IdentificarClienteUseCaseImpl;
import br.com.fiap.fiapeats.core.usecases.PedidoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public PedidoUseCaseImpl pedidoUseCasePort() {
        return new PedidoUseCaseImpl();
    }

    @Bean
    public CriarClienteUseCasePort criarClienteUseCasePort(ClienteRepository clienteRepository) {
        return new CriarClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public IdentificarClienteUseCasePort identificarClienteUseCasePort(ClienteRepository clienteRepository) {
        return new IdentificarClienteUseCaseImpl(clienteRepository);
    }

}
