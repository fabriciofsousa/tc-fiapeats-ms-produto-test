package br.com.fiap.fiapeats.external.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.external.api.mapper.CategoriaMapper;
import br.com.fiap.fiapeats.external.persistence.mapper.ProdutoEntityMapper;
import br.com.fiap.fiapeats.external.persistence.orm.ProdutoEntity;
import br.com.fiap.fiapeats.external.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoEntityMapper produtoEntityMapper;
    private final ProdutoRepositoryJPA produtoRepositoryJPA;
    private final CategoriaMapper categoriaMapper;

    public ProdutoRepositoryImpl(
            ProdutoEntityMapper produtoEntityMapper,
            ProdutoRepositoryJPA produtoRepositoryJPA,
            CategoriaMapper categoriaMapper) {
        this.produtoEntityMapper = produtoEntityMapper;
        this.produtoRepositoryJPA = produtoRepositoryJPA;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoEntityMapper.toProduto(
                produtoRepositoryJPA.save(produtoEntityMapper.toProdutoEntity(produto)));
    }

    @Override
    public Produto editar(Produto produto) {
        return produtoEntityMapper.toProduto(
                produtoRepositoryJPA.save(produtoEntityMapper.toProdutoEntity(produto)));
    }

    @Override
    public Produto consultarPorId(UUID id) {
        return produtoRepositoryJPA.findById(id).map(produtoEntityMapper::toProduto).orElse(null);
    }

    @Override
    public void excluir(UUID id) {
        produtoRepositoryJPA.deleteById(id);
    }

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
