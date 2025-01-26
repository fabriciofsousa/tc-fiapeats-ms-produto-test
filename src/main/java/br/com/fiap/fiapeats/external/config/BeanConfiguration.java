package br.com.fiap.fiapeats.external.config;

import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.CategoriaRepositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.ProdutoRespositoryGatewayImpl;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.CategoriaRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.*;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import br.com.fiap.fiapeats.usecases.produto.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for defining beans related to product operations.
 */
@Configuration
public class BeanConfiguration {

  /**
   * Creates a bean for CriarProdutoUseCase.
   *
   * @param produtoRepositoryGateway the gateway for product repository operations
   * @param categoriaRepositoryGateway the gateway for category repository operations
   * @return an instance of CriarProdutoUseCase
   */
  @Bean
  public CriarProdutoUseCase criarProdutoUseCasePort(
          ProdutoRepositoryGateway produtoRepositoryGateway,
          CategoriaRepositoryGateway categoriaRepositoryGateway) {
    return new CriarProdutoUseCaseImpl(produtoRepositoryGateway, categoriaRepositoryGateway);
  }

  /**
   * Creates a bean for EditarProdutoUseCase.
   *
   * @param produtoRepositoryGateway the gateway for product repository operations
   * @param categoriaRepositoryGateway the gateway for category repository operations
   * @return an instance of EditarProdutoUseCase
   */
  @Bean
  public EditarProdutoUseCase editarProdutoUseCasePort(
          ProdutoRepositoryGateway produtoRepositoryGateway,
          CategoriaRepositoryGateway categoriaRepositoryGateway) {
    return new EditarProdutoUseCaseImpl(produtoRepositoryGateway, categoriaRepositoryGateway);
  }

  /**
   * Creates a bean for ExcluirProdutoUseCase.
   *
   * @param produtoRepositoryGateway the gateway for product repository operations
   * @return an instance of ExcluirProdutoUseCase
   */
  @Bean
  public ExcluirProdutoUseCase excluirProdutoUseCasePort(
          ProdutoRepositoryGateway produtoRepositoryGateway) {
    return new ExcluirProdutoUseCaseImpl(produtoRepositoryGateway);
  }

  /**
   * Creates a bean for ListarProdutosUseCase.
   *
   * @param produtoRepositoryGateway the gateway for product repository operations
   * @return an instance of ListarProdutosUseCase
   */
  @Bean
  public ListarProdutosUseCase listarProdutosUseCasePort(
          ProdutoRepositoryGateway produtoRepositoryGateway) {
    return new ListarProdutosUseCaseImpl(produtoRepositoryGateway);
  }

  /**
   * Creates a bean for ListarProdutosPorCategoriaUseCase.
   *
   * @param produtoRepositoryGateway the gateway for product repository operations
   * @param categoriaRepositoryGateway the gateway for category repository operations
   * @return an instance of ListarProdutosPorCategoriaUseCase
   */
  @Bean
  public ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCasePort(
          ProdutoRepositoryGateway produtoRepositoryGateway,
          CategoriaRepositoryGateway categoriaRepositoryGateway) {
    return new ListarProdutosPorCategoriaUseCaseImpl(
            produtoRepositoryGateway, categoriaRepositoryGateway);
  }

  /**
   * Creates a bean for ProdutoController.
   *
   * @param criarProdutoUseCase the use case for creating products
   * @param editarProdutoUseCase the use case for editing products
   * @param excluirProdutoUseCase the use case for deleting products
   * @param listarProdutosUseCase the use case for listing products
   * @param listarProdutosPorCategoriaUseCase the use case for listing products by category
   * @return an instance of ProdutoController
   */
  @Bean
  public ProdutoController produtoController(
          CriarProdutoUseCase criarProdutoUseCase,
          EditarProdutoUseCase editarProdutoUseCase,
          ExcluirProdutoUseCase excluirProdutoUseCase,
          ListarProdutosUseCase listarProdutosUseCase,
          ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase,
          ListarProdutosPorListaDeIdsUseCase listarProdutosPorListaDeIdsUseCase) {
    return new ProdutoController(
            criarProdutoUseCase,
            editarProdutoUseCase,
            excluirProdutoUseCase,
            listarProdutosUseCase,
            listarProdutosPorCategoriaUseCase, listarProdutosPorListaDeIdsUseCase);
  }

  /**
   * Creates a bean for ProdutoRepositoryGateway.
   *
   * @param produtoRepository the product repository
   * @return an instance of ProdutoRepositoryGateway
   */
  @Bean
  public ProdutoRepositoryGateway produtoRepositoryGateway(ProdutoRepository produtoRepository) {
    return new ProdutoRespositoryGatewayImpl(produtoRepository);
  }

  /**
   * Creates a bean for CategoriaRepositoryGateway.
   *
   * @param categoriaRepository the category repository
   * @return an instance of CategoriaRepositoryGateway
   */
  @Bean
  public CategoriaRepositoryGateway categoriaRepositoryGateway(
          CategoriaRepository categoriaRepository) {
    return new CategoriaRepositoryGatewayImpl(categoriaRepository);
  }

  /**
   * Creates a bean for ListarProdutosPorListaDeIdsUseCase.
   *
   * @param produtoRepositoryGateway the gateway for product repository operations
   * @return an instance of ListarProdutosPorListaDeIdsUseCase
   */
  @Bean
  public ListarProdutosPorListaDeIdsUseCase listarProdutosPorListaDeIdsUseCasePort(
          ProdutoRepositoryGateway produtoRepositoryGateway) {
    return new ListarProdutosPorListaDeIdsUseCaseImpl(produtoRepositoryGateway);
  }
}