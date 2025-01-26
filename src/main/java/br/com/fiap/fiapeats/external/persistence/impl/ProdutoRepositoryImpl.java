package br.com.fiap.fiapeats.external.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.external.api.mapper.CategoriaMapper;
import br.com.fiap.fiapeats.external.persistence.mapper.ProdutoEntityMapper;
import br.com.fiap.fiapeats.external.persistence.orm.ProdutoEntity;
import br.com.fiap.fiapeats.external.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Implementation of the ProdutoRepository interface.
 * Provides methods to interact with the Produto data in the database.
 */
@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

  private final ProdutoEntityMapper produtoEntityMapper;
  private final ProdutoRepositoryJPA produtoRepositoryJPA;
  private final CategoriaMapper categoriaMapper;

  /**
   * Constructs a new ProdutoRepositoryImpl.
   *
   * @param produtoEntityMapper the mapper to convert between Produto and ProdutoEntity
   * @param produtoRepositoryJPA the JPA repository for ProdutoEntity
   * @param categoriaMapper the mapper to convert between Categoria and CategoriaEntity
   */
  public ProdutoRepositoryImpl(
          ProdutoEntityMapper produtoEntityMapper,
          ProdutoRepositoryJPA produtoRepositoryJPA,
          CategoriaMapper categoriaMapper) {
    this.produtoEntityMapper = produtoEntityMapper;
    this.produtoRepositoryJPA = produtoRepositoryJPA;
    this.categoriaMapper = categoriaMapper;
  }

  /**
   * Saves a product.
   *
   * @param produto the product to be saved
   * @return the saved product
   */
  @Override
  public Produto salvar(Produto produto) {
    return produtoEntityMapper.toProduto(
            produtoRepositoryJPA.save(produtoEntityMapper.toProdutoEntity(produto)));
  }

  /**
   * Edits a product.
   *
   * @param produto the product to be edited
   * @return the edited product
   */
  @Override
  public Produto editar(Produto produto) {
    return produtoEntityMapper.toProduto(
            produtoRepositoryJPA.save(produtoEntityMapper.toProdutoEntity(produto)));
  }

  /**
   * Consults a product by its ID.
   *
   * @param id the UUID of the product to be consulted
   * @return the consulted product, or null if not found
   */
  @Override
  public Produto consultarPorId(UUID id) {
    return produtoRepositoryJPA.findById(id).map(produtoEntityMapper::toProduto).orElse(null);
  }

  /**
   * Deletes a product by its ID.
   *
   * @param id the UUID of the product to be deleted
   */
  @Override
  public void excluir(UUID id) {
    produtoRepositoryJPA.deleteById(id);
  }

  /**
   * Lists products by category ID.
   *
   * @param idCategoria the ID of the category to filter products by
   * @return the list of products in the specified category
   * @throws NotFoundException if no products are found
   */
  @Override
  public List<Produto> listarProdutosPorcategoria(Long idCategoria) {
    List<ProdutoEntity> products = produtoRepositoryJPA.findProductByCategoryId(idCategoria);
    if (products.isEmpty()) throw new NotFoundException("Não foram encontrados produtos!");
    return products.stream()
            .map(
                    p ->
                            new Produto(
                                    p.getId(),
                                    p.getNome(),
                                    p.getDescricao(),
                                    p.getValor(),
                                    categoriaMapper.toCategoriaFromCategoriaEntity(p.getCategoria()),
                                    p.getImagemUrl()))
            .toList();
  }

  /**
   * Lists products by a list of UUIDs.
   *
   * @param uuids the list of UUIDs to filter products by
   * @return the list of products corresponding to the provided UUIDs, or null if no products are found
   * @throws NotFoundException if all items in the result are null
   */
  @Override
  public List<Produto> listarProdutosPorListaDeIds(List<UUID> uuids) {
    List<ProdutoEntity> products = produtoRepositoryJPA.findAllById(uuids);

    if (products.isEmpty()) {
      throw new NotFoundException("Não foram encontrados produtos!");
    }

    List<Produto> result = products.stream()
            .map(produtoEntityMapper::toProduto)
            .collect(Collectors.toList());

    if (result.stream().allMatch(Objects::isNull)) {
      throw new NotFoundException("Não foram encontrados produtos!");
    }

    return result;
  }

  /**
   * Lists all products.
   *
   * @return the list of all products
   * @throws NotFoundException if no products are found
   */
  @Override
  public List<Produto> listarProdutos() {
    List<ProdutoEntity> products = produtoRepositoryJPA.findAll();
    if (products.isEmpty()) throw new NotFoundException("Não foram encontrados produtos!");
    return products.stream()
            .map(
                    p ->
                            new Produto(
                                    p.getId(),
                                    p.getNome(),
                                    p.getDescricao(),
                                    p.getValor(),
                                    categoriaMapper.toCategoriaFromCategoriaEntity(p.getCategoria()),
                                    p.getImagemUrl()))
            .toList();
  }
}