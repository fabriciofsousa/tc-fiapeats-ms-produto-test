package br.com.fiap.fiapeats.unitTests.external.config;

import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.CategoriaRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.external.config.BeanConfiguration;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.*;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;

import static org.assertj.core.api.Assertions.assertThat;

class BeanConfigurationTest {

  private AnnotationConfigApplicationContext context;

  @BeforeEach
  void setUp() {
    context = new AnnotationConfigApplicationContext(TestConfig.class);
  }

  @Test
  void criarProdutoUseCaseBeanIsLoaded() {
    CriarProdutoUseCase bean = context.getBean(CriarProdutoUseCase.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void editarProdutoUseCaseBeanIsLoaded() {
    EditarProdutoUseCase bean = context.getBean(EditarProdutoUseCase.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void excluirProdutoUseCaseBeanIsLoaded() {
    ExcluirProdutoUseCase bean = context.getBean(ExcluirProdutoUseCase.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void listarProdutosUseCaseBeanIsLoaded() {
    ListarProdutosUseCase bean = context.getBean(ListarProdutosUseCase.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void listarProdutosPorCategoriaUseCaseBeanIsLoaded() {
    ListarProdutosPorCategoriaUseCase bean = context.getBean(ListarProdutosPorCategoriaUseCase.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void produtoControllerBeanIsLoaded() {
    ProdutoController bean = context.getBean(ProdutoController.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void produtoRepositoryGatewayBeanIsLoaded() {
    ProdutoRepositoryGateway bean = context.getBean(ProdutoRepositoryGateway.class);
    assertThat(bean).isNotNull();
  }

  @Test
  void categoriaRepositoryGatewayBeanIsLoaded() {
    CategoriaRepositoryGateway bean = context.getBean(CategoriaRepositoryGateway.class);
    assertThat(bean).isNotNull();
  }

  @Configuration
  @Import(BeanConfiguration.class)
  static class TestConfig {

    @Bean
    @Primary
    public ProdutoRepository produtoRepository() {
      return Mockito.mock(ProdutoRepository.class);
    }

    @Bean
    @Primary
    public CategoriaRepository categoriaRepository() {
      return Mockito.mock(CategoriaRepository.class);
    }
  }
}