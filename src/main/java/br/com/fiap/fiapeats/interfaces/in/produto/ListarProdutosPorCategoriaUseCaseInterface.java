package br.com.fiap.fiapeats.interfaces.in.produto;

import br.com.fiap.fiapeats.entities.Produto;
import java.util.List;

public interface ListarProdutosPorCategoriaUseCaseInterface {
  List<Produto> listarProdutosPorCategoria(String categoria);
}
