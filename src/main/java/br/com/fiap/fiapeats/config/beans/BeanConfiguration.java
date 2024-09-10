package br.com.fiap.fiapeats.config.beans;

import br.com.fiap.fiapeats.interfaces.in.categoria.ConsultarCategoriaUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.in.cliente.CriarClienteUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.in.cliente.IdentificarClienteUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.in.pedido.CriarPedidoUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.in.pedido.ListarPedidosUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.in.produto.*;
import br.com.fiap.fiapeats.interfaces.out.CategoriaRepositoryInterface;
import br.com.fiap.fiapeats.interfaces.out.ClienteRepositoryInterface;
import br.com.fiap.fiapeats.interfaces.out.PedidoRepositoryInterface;
import br.com.fiap.fiapeats.interfaces.out.ProdutoRepositoryInterface;
import br.com.fiap.fiapeats.usecases.categoria.ConsultarCategoriaUseCaseImpl;
import br.com.fiap.fiapeats.usecases.cliente.CriarClienteUseCaseImpl;
import br.com.fiap.fiapeats.usecases.cliente.IdentificarClienteUseCaseImpl;
import br.com.fiap.fiapeats.usecases.pedido.CriarPedidoUseCaseImpl;
import br.com.fiap.fiapeats.usecases.pedido.ListarPedidosUseCaseImpl;
import br.com.fiap.fiapeats.usecases.produto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarPedidoUseCaseInterface criarPedidoUseCasePort(PedidoRepositoryInterface pedidoRepositoryInterface) {
        return new CriarPedidoUseCaseImpl(pedidoRepositoryInterface);
    }

    @Bean
    public CriarClienteUseCaseInterface criarClienteUseCasePort(ClienteRepositoryInterface clienteRepositoryInterface) {
        return new CriarClienteUseCaseImpl(clienteRepositoryInterface);
    }

    @Bean
    public IdentificarClienteUseCaseInterface identificarClienteUseCasePort(
            ClienteRepositoryInterface clienteRepositoryInterface) {
        return new IdentificarClienteUseCaseImpl(clienteRepositoryInterface);
    }

    @Bean
    public CriarProdutoUseCaseInterface criarProdutoUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface,
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new CriarProdutoUseCaseImpl(produtoRepositoryInterface, categoriaRepositoryInterface);
    }

    @Bean
    public ConsultarCategoriaUseCaseInterface consultarCategoriaUseCasePort(
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new ConsultarCategoriaUseCaseImpl(categoriaRepositoryInterface);
    }

    @Bean
    public EditarProdutoUseCaseInterface editarProdutoUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface,
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new EditarProdutoUseCaseImpl(produtoRepositoryInterface, categoriaRepositoryInterface);
    }

    @Bean
    public ExcluirProdutoUseCaseInterface excluirProdutoUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface) {
        return new ExcluirProdutoUseCaseImpl(produtoRepositoryInterface);
    }

    @Bean
    public ListarPedidosUseCaseInterface listarPedidosUseCasePort(PedidoRepositoryInterface pedidoRepositoryInterface) {
        return new ListarPedidosUseCaseImpl(pedidoRepositoryInterface);
    }

    @Bean
    public ListarProdutosUseCaseInterface listarProdutosUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface) {
        return new ListarProdutosUseCaseImpl(produtoRepositoryInterface);
    }

    @Bean
    public ListarProdutosPorCategoriaUseCaseInterface listarProdutosPorCategoriaUseCasePort(
            ProdutoRepositoryInterface produtoRepositoryInterface,
            CategoriaRepositoryInterface categoriaRepositoryInterface) {
        return new ListarProdutosPorCategoriaUseCaseImpl(
                produtoRepositoryInterface, categoriaRepositoryInterface);
    }
}
