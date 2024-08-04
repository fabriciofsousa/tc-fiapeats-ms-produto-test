package br.com.fiap.fiapeats.adapter.beans;

import br.com.fiap.fiapeats.core.ports.in.*;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ClienteRepository;
import br.com.fiap.fiapeats.core.usecases.CriarClienteUseCaseImpl;
import br.com.fiap.fiapeats.core.usecases.IdentificarClienteUseCaseImpl;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import br.com.fiap.fiapeats.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarClienteUseCasePort criarClienteUseCasePort(ClienteRepository clienteRepository) {
        return new CriarClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public IdentificarClienteUseCasePort identificarClienteUseCasePort(
            ClienteRepository clienteRepository) {
        return new IdentificarClienteUseCaseImpl(clienteRepository);
    }

    @Bean
    public CriarProdutoUseCasePort criarProdutoUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort,
            CategoriaRepositoryPort categoriaRepositoryPort) {
        return new CriarProdutoUseCaseImpl(produtoRepositoryPort, categoriaRepositoryPort);
    }

    @Bean
    public ConsultarCategoriaUseCasePort consultarCategoriaUseCasePort(
            CategoriaRepositoryPort categoriaRepositoryPort) {
        return new ConsultarCategoriaUseCaseImpl(categoriaRepositoryPort);
    }

    @Bean
    public EditarProdutoUseCasePort editarProdutoUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort,
            CategoriaRepositoryPort categoriaRepositoryPort) {
        return new EditarProdutoUseCaseImpl(produtoRepositoryPort, categoriaRepositoryPort);
    }

    @Bean
    public ExcluirProdutoUseCasePort excluirProdutoUseCasePort(
            ProdutoRepositoryPort produtoRepositoryPort) {
        return new ExcluirProdutoUseCaseImpl(produtoRepositoryPort);
    }
}
