package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoResponse;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;
import java.util.List;

/**
 * Presenter class for Produto.
 * Provides methods to convert Produto entities to various response DTOs.
 */
public class ProdutoPresenter {

  /**
   * Private constructor to hide the implicit public one.
   */
  private ProdutoPresenter() {
    // Private constructor to hide the implicit public one
  }

  /**
   * Converts a Produto entity to a CriarProdutoResponse DTO.
   *
   * @param produto the Produto entity to be converted
   * @return the CriarProdutoResponse DTO
   */
  public static CriarProdutoResponse toCriarProdutoResponse(Produto produto) {
    return new CriarProdutoResponse(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getValor(),
            produto.getCategoria().getDescricao(),
            produto.getImagemUrl());
  }

  /**
   * Converts a Produto entity to an EditarProdutoResponse DTO.
   *
   * @param produto the Produto entity to be converted
   * @return the EditarProdutoResponse DTO
   */
  public static EditarProdutoResponse toEditarProdutoResponse(Produto produto) {
    return new EditarProdutoResponse(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getValor(),
            produto.getCategoria().getDescricao(),
            produto.getImagemUrl());
  }

  /**
   * Converts a list of Produto entities to a list of ProdutoResponse DTOs.
   *
   * @param produtos the list of Produto entities to be converted
   * @return the list of ProdutoResponse DTOs
   */
  public static List<ProdutoResponse> toProdutosResponse(List<Produto> produtos) {
    return produtos.stream().map(ProdutoResponse::new).toList();
  }

}