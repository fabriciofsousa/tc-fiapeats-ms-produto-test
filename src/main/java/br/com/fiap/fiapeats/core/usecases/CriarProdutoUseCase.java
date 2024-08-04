package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.in.Exception.CategoriaInvalida;
import br.com.fiap.fiapeats.adapter.in.Exception.ProdutoNaoEncontrado;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ProdutoResponse;
import br.com.fiap.fiapeats.core.domain.CategoriaProduto;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.ProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CriarProdutoUseCase implements ProdutoUseCasePort {

    private final ProdutoRepository produtoRepository;

    public CriarProdutoUseCase(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto criar(Produto produto) {
        validarCategoria(produto);

        var produtoCriado = produtoRepository.criar(produto);
        return new Produto(produtoCriado.getId(), produtoCriado.getNome(), produtoCriado.getDescricao(), produtoCriado.getValor(), produtoCriado.getCategoria(), produtoCriado.getImagemUrl());
    }

    @Override
    public Produto editar(UUID id, Produto produto) {
        validarCategoria(produto);

        if(produtoRepository.consultar(id).isEmpty()){
            throw new ProdutoNaoEncontrado("Produto " + id + " não encontrado");
        }

        var produtoEditado = produtoRepository.editar(new Produto(id, produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria(), produto.getImagemUrl()));
        return new Produto(produtoEditado.getId(), produtoEditado.getNome(), produtoEditado.getDescricao(), produtoEditado.getValor(), produtoEditado.getCategoria(), produtoEditado.getImagemUrl());
    }

    @Override
    public void excluir(UUID id) {
        if(produtoRepository.consultar(id).isEmpty()){
            throw new ProdutoNaoEncontrado("Produto " + id + " não encontrado");
        }

        produtoRepository.excluir(id);
    }

    private void validarCategoria(Produto produto) {
        if(CategoriaProduto.getCategoria(produto.getCategoria()) == null){
            throw new CategoriaInvalida("Categoria " + produto.getCategoria() + " inválida");
        }
    }
}
