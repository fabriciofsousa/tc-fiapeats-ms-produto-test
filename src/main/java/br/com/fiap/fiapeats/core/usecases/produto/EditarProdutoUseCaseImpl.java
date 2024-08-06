package br.com.fiap.fiapeats.core.usecases.produto;

import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.exceptions.CategoriaInvalida;
import br.com.fiap.fiapeats.core.exceptions.NotFoundException;
import br.com.fiap.fiapeats.core.ports.in.produto.EditarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.CategoriaRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

public class EditarProdutoUseCaseImpl implements EditarProdutoUseCasePort {

  private final ProdutoRepositoryPort produtoRepositoryPort;

  private final CategoriaRepositoryPort categoriaRepositoryPort;

  public EditarProdutoUseCaseImpl(
      ProdutoRepositoryPort produtoRepositoryPort,
      CategoriaRepositoryPort categoriaRepositoryPort) {
    this.produtoRepositoryPort = produtoRepositoryPort;
    this.categoriaRepositoryPort = categoriaRepositoryPort;
  }

  @Override
  public Produto editar(Produto produto) {

    var produtoConsultado = produtoRepositoryPort.consultarPorId(produto.getId());

    if (produtoConsultado == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    var categoria = categoriaRepositoryPort.consultar(produto.getCategoria());

    if (categoria == null) {
      throw new CategoriaInvalida("Categoria informada inválida");
    }

    return produtoRepositoryPort.editar(produto.adicionarCategoria(produto, categoria));
  }
}
