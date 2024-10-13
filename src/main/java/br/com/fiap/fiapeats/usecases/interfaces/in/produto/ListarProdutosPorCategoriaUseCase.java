package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import java.util.List;

public interface ListarProdutosPorCategoriaUseCase {
  List<Produto> listarProdutosPorCategoria(String categoria);
}
