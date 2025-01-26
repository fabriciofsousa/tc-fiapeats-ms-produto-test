package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;
import br.com.fiap.fiapeats.usecases.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.EditarProdutoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;

/**
 * Implementation of the EditarProdutoUseCase interface.
 */
public class EditarProdutoUseCaseImpl implements EditarProdutoUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;
  private final CategoriaRepositoryGateway categoriaRepositoryGateway;

  /**
   * Constructs a new EditarProdutoUseCaseImpl with the specified repository gateways.
   *
   * @param produtoRepositoryGateway the repository gateway to access product data
   * @param categoriaRepositoryGateway the repository gateway to access category data
   */
  public EditarProdutoUseCaseImpl(
          ProdutoRepositoryGateway produtoRepositoryGateway,
          CategoriaRepositoryGateway categoriaRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
    this.categoriaRepositoryGateway = categoriaRepositoryGateway;
  }

  /**
   * Edits a product based on the provided DTO.
   *
   * @param editarProdutoDTO the DTO containing the product details to be edited
   * @return the edited product
   * @throws NotFoundException if the product is not found
   * @throws CategoriaInvalidaException if the provided category is invalid
   */
  @Override
  public Produto editar(EditarProdutoDTO editarProdutoDTO) {
    Produto produto =
            new Produto(
                    editarProdutoDTO.getId(),
                    editarProdutoDTO.getNome(),
                    editarProdutoDTO.getDescricao(),
                    editarProdutoDTO.getValor(),
                    Categoria.adicionarDescricao(editarProdutoDTO.getCategoria()),
                    editarProdutoDTO.getImagemUrl());

    var produtoConsultado = produtoRepositoryGateway.consultarPorId(produto.getId());

    if (produtoConsultado == null) {
      throw new NotFoundException("Produto não encontrado");
    }

    var categoria = categoriaRepositoryGateway.consultar(produto.getCategoria());

    if (categoria == null) {
      throw new CategoriaInvalidaException("Categoria informada inválida");
    }

    return produtoRepositoryGateway.editar(produto.adicionarCategoria(produto, categoria));
  }
}