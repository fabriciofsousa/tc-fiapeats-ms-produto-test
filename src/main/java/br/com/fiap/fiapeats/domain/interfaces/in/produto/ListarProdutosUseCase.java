package br.com.fiap.fiapeats.domain.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import java.util.List;

public interface ListarProdutosUseCase {
  List<Produto> listarProdutos();
}
