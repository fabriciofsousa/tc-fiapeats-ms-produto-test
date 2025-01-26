package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;
import br.com.fiap.fiapeats.usecases.exceptions.CategoriaInvalidaException;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.CriarProdutoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.categoria.CategoriaRepositoryGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;

/**
 * Implementation of the CriarProdutoUseCase interface.
 */
public class CriarProdutoUseCaseImpl implements CriarProdutoUseCase {

  private final ProdutoRepositoryGateway produtoRepositoryGateway;
  private final CategoriaRepositoryGateway categoriaRepositoryGateway;

  /**
   * Constructs a new CriarProdutoUseCaseImpl with the specified repository gateways.
   *
   * @param produtoRepositoryGateway the repository gateway to access product data
   * @param categoriaRepositoryGateway the repository gateway to access category data
   */
  public CriarProdutoUseCaseImpl(
          ProdutoRepositoryGateway produtoRepositoryGateway,
          CategoriaRepositoryGateway categoriaRepositoryGateway) {
    this.produtoRepositoryGateway = produtoRepositoryGateway;
    this.categoriaRepositoryGateway = categoriaRepositoryGateway;
  }

  /**
   * Creates a product based on the provided DTO.
   *
   * @param criarProdutoDTO the DTO containing the product details to be created
   * @return the created product
   * @throws CategoriaInvalidaException if the provided category is invalid
   */
  @Override
  public Produto criar(CriarProdutoDTO criarProdutoDTO) {
    Produto produto =
            new Produto(
                    criarProdutoDTO.getNome(),
                    criarProdutoDTO.getDescricao(),
                    criarProdutoDTO.getValor(),
                    Categoria.adicionarDescricao(criarProdutoDTO.getCategoria()),
                    criarProdutoDTO.getImagemUrl());

    var categoria = categoriaRepositoryGateway.consultar(produto.getCategoria());

    if (categoria == null) {
      throw new CategoriaInvalidaException("Categoria informada inválida");
    }
    return produtoRepositoryGateway.salvar(produto.adicionarCategoria(produto, categoria));
  }
}