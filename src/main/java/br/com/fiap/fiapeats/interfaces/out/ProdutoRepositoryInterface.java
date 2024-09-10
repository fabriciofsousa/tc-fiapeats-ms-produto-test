package br.com.fiap.fiapeats.interfaces.out;

import br.com.fiap.fiapeats.entities.Produto;
import java.util.List;
import java.util.UUID;

public interface ProdutoRepositoryInterface {
  Produto salvar(Produto produto);

  Produto editar(Produto produto);

  Produto consultarPorId(UUID id);

  void excluir(UUID id);

  List<Produto> listarProdutos();

  List<Produto> listarProdutosPorcategoria(Long idCategoria);
}
