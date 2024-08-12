package br.com.fiap.fiapeats.core.ports.in.produto;

import br.com.fiap.fiapeats.core.domain.Produto;
import java.util.List;

public interface ListarProdutosPorCategoriaUseCasePort {
  List<Produto> listarProdutosPorCategoria(String categoria);
}
