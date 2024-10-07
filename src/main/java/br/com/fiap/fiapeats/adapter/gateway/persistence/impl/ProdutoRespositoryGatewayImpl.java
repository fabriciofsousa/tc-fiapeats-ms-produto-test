package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.ProdutoRepository;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;

import java.util.List;
import java.util.UUID;

public class ProdutoRespositoryGatewayImpl implements ProdutoRepositoryGateway {

    private final ProdutoRepository produtoRepository;

    public ProdutoRespositoryGatewayImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvar(Produto produto) {
        return produtoRepository.salvar(produto);
    }

    @Override
    public Produto editar(Produto produto) {
        return produtoRepository.editar(produto);
    }

    @Override
    public Produto consultarPorId(UUID id) {
        return produtoRepository.consultarPorId(id);
    }

    @Override
    public void excluir(UUID id) {
        produtoRepository.excluir(id);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.listarProdutos();
    }

    @Override
    public List<Produto> listarProdutosPorcategoria(Long idCategoria) {
        return produtoRepository.listarProdutosPorcategoria(idCategoria);
    }
}
