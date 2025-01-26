package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import java.util.List;

/**
 * Use case interface for listing all products.
 */
public interface ListarProdutosUseCase {

  /**
   * Lists all products.
   *
   * @return the list of all products
   */
  List<Produto> listarProdutos();
}