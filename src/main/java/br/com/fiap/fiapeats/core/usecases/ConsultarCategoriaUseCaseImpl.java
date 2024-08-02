package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.ConsultarCategoriaUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.CriarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsultarCategoriaUseCaseImpl implements ConsultarCategoriaUseCasePort {

  private final CategoriaRepositoryPort categoriaRepositoryPort;

  public ConsultarCategoriaUseCaseImpl(CategoriaRepositoryPort categoriaRepositoryPort) {
    this.categoriaRepositoryPort = categoriaRepositoryPort;
  }


  @Override
  public Categoria consultar(Categoria categoria) {
    return categoriaRepositoryPort.consultar(categoria);
  }
}
