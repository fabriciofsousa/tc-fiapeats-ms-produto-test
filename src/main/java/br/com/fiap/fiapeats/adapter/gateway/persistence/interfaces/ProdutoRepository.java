package br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces;

import br.com.fiap.fiapeats.domain.entities.Produto;

import java.util.List;
import java.util.UUID;

/**
 * Interface for the Produto repository.
 */
public interface ProdutoRepository {

    /**
     * Saves a product.
     *
     * @param produto the product to be saved
     * @return the saved product
     */
    Produto salvar(Produto produto);

    /**
     * Edits a product.
     *
     * @param produto the product to be edited
     * @return the edited product
     */
    Produto editar(Produto produto);

    /**
     * Consults a product by its ID.
     *
     * @param id the UUID of the product to be consulted
     * @return the consulted product
     */
    Produto consultarPorId(UUID id);

    /**
     * Deletes a product by its ID.
     *
     * @param id the UUID of the product to be deleted
     */
    void excluir(UUID id);

    /**
     * Lists all products.
     *
     * @return the list of all products
     */
    List<Produto> listarProdutos();

    /**
     * Lists products by category ID.
     *
     * @param idCategoria the ID of the category to filter products by
     * @return the list of products in the specified category
     */
    List<Produto> listarProdutosPorcategoria(Long idCategoria);

    /**
     * Lists products by a list of UUIDs.
     *
     * @param uuids the list of UUIDs to filter products by
     * @return the list of products corresponding to the provided UUIDs
     */
    List<Produto> listarProdutosPorListaDeIds(List<UUID> uuids);
}