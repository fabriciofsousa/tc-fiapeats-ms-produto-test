package br.com.fiap.fiapeats.external.config;

import br.com.fiap.fiapeats.adapter.controller.ClienteController;
import br.com.fiap.fiapeats.adapter.controller.PedidoController;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.ClienteRepositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.PedidoRepositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ClienteRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.PedidoRepository;
import br.com.fiap.fiapeats.domain.interfaces.in.categoria.ConsultarCategoriaUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.cliente.IdentificarClienteUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.pedido.CriarPedidoUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.pedido.ListarPedidosUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.produto.*;
import br.com.fiap.fiapeats.domain.interfaces.out.categoria.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.domain.interfaces.out.cliente.ClienteRepositoryGateway;
import br.com.fiap.fiapeats.domain.interfaces.out.pedido.PedidoRepositoryGateway;
import br.com.fiap.fiapeats.domain.interfaces.out.produto.ProdutoRepositoryInterface;
import br.com.fiap.fiapeats.domain.usecases.categoria.ConsultarCategoriaUseCaseImpl;
import br.com.fiap.fiapeats.domain.usecases.cliente.CriarClienteUseCaseImpl;
import br.com.fiap.fiapeats.domain.usecases.cliente.IdentificarClienteUseCaseImpl;
import br.com.fiap.fiapeats.domain.usecases.pedido.CriarPedidoUseCaseImpl;
import br.com.fiap.fiapeats.domain.usecases.pedido.ListarPedidosUseCaseImpl;
import br.com.fiap.fiapeats.domain.usecases.produto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarPedidoUseCase criarPedidoUseCasePort(PedidoRepositoryGateway pedidoRepositoryGateway) {
        return new CriarPedidoUseCaseImpl(pedidoRepositoryGateway);
    }

    @Bean
    public CriarClienteUseCase criarClienteUseCasePort(ClienteRepositoryGateway clienteRepositoryInterface) {
        return new CriarClienteUseCaseImpl(clienteRepositoryInterface);
    }

    @Bean
    public IdentificarClienteUseCase identificarClienteUseCasePort(
            ClienteRepositoryGateway clienteRepositoryInterface) {
        return new IdentificarClienteUseCaseImpl(clienteRepositoryInterface);
    }

    @Bean
    public CriarProdutoUseCase criarProdutoUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface,
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new CriarProdutoUseCaseImpl(produtoRepositoryInterface, categoriaRepositoryInterface);
    }

    @Bean
    public ConsultarCategoriaUseCase consultarCategoriaUseCasePort(
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new ConsultarCategoriaUseCaseImpl(categoriaRepositoryInterface);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface,
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new EditarProdutoUseCaseImpl(produtoRepositoryInterface, categoriaRepositoryInterface);
    }

    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface) {
        return new ExcluirProdutoUseCaseImpl(produtoRepositoryInterface);
    }

    @Bean
    public ListarPedidosUseCase listarPedidosUseCasePort(PedidoRepositoryGateway pedidoRepositoryGateway) {
        return new ListarPedidosUseCaseImpl(pedidoRepositoryGateway);
    }

    @Bean
    public ListarProdutosUseCase listarProdutosUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface) {
        return new ListarProdutosUseCaseImpl(produtoRepositoryInterface);
    }

    @Bean
    public ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface,
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new ListarProdutosPorCategoriaUseCaseImpl(
                produtoRepositoryInterface, categoriaRepositoryInterface);
    }

    @Bean
    public ClienteController clienteController(CriarClienteUseCase criarClienteUseCase,
                                               IdentificarClienteUseCase identificarClienteUseCase) {
        return new ClienteController(criarClienteUseCase, identificarClienteUseCase);
    }

    @Bean
    public ClienteRepositoryGateway clienteRepositoryGateway(ClienteRepository clienteRepository) {
        return new ClienteRepositoryGatewayImpl(clienteRepository);
    }

    @Bean
    public PedidoController pedidoController(CriarPedidoUseCase criarPedidoUseCase,
                                             ListarPedidosUseCase listarPedidoUseCase) {
        return new PedidoController(criarPedidoUseCase, listarPedidoUseCase);
    }

    @Bean
    public PedidoRepositoryGateway pedidoRepositoryGateway(PedidoRepository pedidoRepository) {
        return new PedidoRepositoryGatewayImpl(pedidoRepository);
    }
}
