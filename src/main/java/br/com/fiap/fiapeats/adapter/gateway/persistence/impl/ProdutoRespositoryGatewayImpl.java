package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the ProdutoRepositoryGateway interface.
 * Provides methods to interact with the Produto data through the gateway.
 */
public class ProdutoRespositoryGatewayImpl implements ProdutoRepositoryGateway {

    private final ProdutoRepository produtoRepository;

    /**
     * Constructs a new ProdutoRespositoryGatewayImpl.
     *
     * @param produtoRepository the repository to interact with Produto data
     */
    public ProdutoRespositoryGatewayImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Saves a product.
     *
     * @param produto the product to be saved
     * @return the saved product
     */
    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.salvar(produto);
    }

    /**
     * Edits a product.
     *
     * @param produto the product to be edited
     * @return the edited product
     */
    @Override
    public Produto editar(Produto produto) {
        return produtoRepository.editar(produto);
    }

    /**
     * Consults a product by its ID.
     *
     * @param id the UUID of the product to be consulted
     * @return the consulted product, or null if not found
     */
    @Override
    public Produto consultarPorId(UUID id) {
        return produtoRepository.consultarPorId(id);
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the UUID of the product to be deleted
     */
    @Override
    public void excluir(UUID id) {
        produtoRepository.excluir(id);
    }

    /**
     * Lists all products.
     *
     * @return the list of all products
     */
    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.listarProdutos();
    }

    /**
     * Lists products by category ID.
     *
     * @param idCategoria the ID of the category to filter products by
     * @return the list of products in the specified category
     */
    @Override
    public List<Produto> listarProdutosPorCategoria(Long idCategoria) {
        return produtoRepository.listarProdutosPorcategoria(idCategoria);
    }

    /**
     * Lists products by a list of UUIDs.
     *
     * @param uuids the list of UUIDs to filter products by
     * @return the list of products corresponding to the provided UUIDs
     */
    @Override
    public List<Produto> listarProdutosPorListaDeIds(List<UUID> uuids) {
        return produtoRepository.listarProdutosPorListaDeIds(uuids);
    }
}