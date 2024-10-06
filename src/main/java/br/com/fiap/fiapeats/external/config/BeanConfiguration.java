package br.com.fiap.fiapeats.external.config;

import br.com.fiap.fiapeats.adapter.controller.ClienteController;
import br.com.fiap.fiapeats.adapter.controller.PagamentoController;
import br.com.fiap.fiapeats.adapter.controller.PedidoController;
import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.adapter.gateway.integration.impl.PagamentoGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.integration.interfaces.PagamentoIntegration;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.CategoriaRepositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.ClienteRepositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.PedidoRepositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.ProdutoRespositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.CategoriaRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ClienteRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.PedidoRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.external.integration.feign.AutenticacaoFeign;
import br.com.fiap.fiapeats.external.integration.feign.PedidoFeign;
import br.com.fiap.fiapeats.external.integration.impl.PagamentoIntegrationImpl;
import br.com.fiap.fiapeats.usecases.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.cliente.IdentificarClienteUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pagamento.CriarPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.CriarPedidoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.*;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.cliente.ClienteRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.pagamento.PagamentoGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import br.com.fiap.fiapeats.usecases.cliente.CriarClienteUseCaseImpl;
import br.com.fiap.fiapeats.usecases.cliente.IdentificarClienteUseCaseImpl;
import br.com.fiap.fiapeats.usecases.pagamento.CriarPagamentoUseCaseImpl;
import br.com.fiap.fiapeats.usecases.pedido.CriarPedidoUseCaseImpl;
import br.com.fiap.fiapeats.usecases.pedido.ListarPedidosUseCaseImpl;
import br.com.fiap.fiapeats.usecases.produto.*;
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
            ProdutoRepositoryGateway produtoRepositoryGateway,
            CategoriaRepositoryGateway categoriaRepositoryGateway) {
        return new CriarProdutoUseCaseImpl(produtoRepositoryGateway, categoriaRepositoryGateway);
    }

    @Bean
    public EditarProdutoUseCase editarProdutoUseCasePort(
            ProdutoRepositoryGateway produtoRepositoryGateway,
            CategoriaRepositoryGateway categoriaRepositoryGateway) {
        return new EditarProdutoUseCaseImpl(produtoRepositoryGateway, categoriaRepositoryGateway);
    }

    @Bean
    public ExcluirProdutoUseCase excluirProdutoUseCasePort(
            ProdutoRepositoryGateway produtoRepositoryGateway) {
        return new ExcluirProdutoUseCaseImpl(produtoRepositoryGateway);
    }

    @Bean
    public ListarPedidosUseCase listarPedidosUseCasePort(PedidoRepositoryGateway pedidoRepositoryGateway) {
        return new ListarPedidosUseCaseImpl(pedidoRepositoryGateway);
    }

    @Bean
    public ListarProdutosUseCase listarProdutosUseCasePort(
            ProdutoRepositoryGateway produtoRepositoryGateway) {
        return new ListarProdutosUseCaseImpl(produtoRepositoryGateway);
    }

    @Bean
    public ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCasePort(
            ProdutoRepositoryGateway produtoRepositoryGateway,
            CategoriaRepositoryGateway categoriaRepositoryGateway) {
        return new ListarProdutosPorCategoriaUseCaseImpl(
                produtoRepositoryGateway, categoriaRepositoryGateway);
    }

    @Bean
    public CriarPagamentoUseCase criarPagamentoUseCasePort(PedidoRepositoryGateway pedidoRepositoryGateway,
                                                           PagamentoGateway pagamentoGateway) {
        return new CriarPagamentoUseCaseImpl(pedidoRepositoryGateway, pagamentoGateway);
    }

    @Bean
    public ClienteRepositoryGateway clienteRepositoryGateway(ClienteRepository clienteRepository) {
        return new ClienteRepositoryGatewayImpl(clienteRepository);
    }

    @Bean
    public PagamentoGateway pagamentoGateway(PagamentoIntegration pagamentoIntegration){
        return new PagamentoGatewayImpl(pagamentoIntegration);
    }

    @Bean
    public PagamentoIntegration pagamentoIntegration(AutenticacaoFeign autenticacaoFeign, PedidoFeign pedidoFeign){
        return new PagamentoIntegrationImpl(autenticacaoFeign, pedidoFeign);
    }

    @Bean
    public ClienteController clienteController(CriarClienteUseCase criarClienteUseCase,
                                               IdentificarClienteUseCase identificarClienteUseCase) {
        return new ClienteController(criarClienteUseCase, identificarClienteUseCase);
    }

    @Bean
    public PagamentoController pagamentoController(CriarPagamentoUseCase criarPagamentoUseCase) {
        return new PagamentoController(criarPagamentoUseCase);
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

    @Bean
    public ProdutoController produtoController(CriarProdutoUseCase criarProdutoUseCase,
                                               EditarProdutoUseCase editarProdutoUseCase,
                                               ExcluirProdutoUseCase excluirProdutoUseCase,
                                               ListarProdutosUseCase listarProdutosUseCase,
                                               ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase) {
        return new ProdutoController(criarProdutoUseCase, editarProdutoUseCase, excluirProdutoUseCase, listarProdutosUseCase, listarProdutosPorCategoriaUseCase);
    }

    @Bean
    public ProdutoRepositoryGateway produtoRepositoryGateway(ProdutoRepository produtoRepository) {
        return new ProdutoRespositoryGatewayImpl(produtoRepository);
    }

    @Bean
    public CategoriaRepositoryGateway categoriaRepositoryGateway(CategoriaRepository categoriaRepository) {
        return new CategoriaRepositoryGatewayImpl(categoriaRepository);
    }
}
