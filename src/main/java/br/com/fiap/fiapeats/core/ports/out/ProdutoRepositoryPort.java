package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Produto;
import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryPort {
  Produto salvar(Produto produto);

  Produto editar(Produto produto);

  Produto consultarPorId(UUID id);

  void excluir(UUID id);

  List<Produto> listarProdutos();

  List<Produto> listarProdutosPorcategoria(Long idCategoria);
}
