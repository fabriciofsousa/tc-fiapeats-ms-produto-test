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
    public ProdutoResponse criar(Produto produto) {
        var categoria = CategoriaProduto.getCategoria(produto.getCategoria());
        if(categoria == null){
            throw new CategoriaInvalida("Categoria " + categoria + "inválida");
        }

        var produtoCriado = produtoRepository.criar(produto);
        return new ProdutoResponse(produtoCriado.getId(), produtoCriado.getNome(), produtoCriado.getDescricao(), produto.getCategoria(), produtoCriado.getValor());
    }

    @Override
    public void editar(UUID id, Produto produto) {

        var existeProduto = produtoRepository.consultar(id);

        if(existeProduto.isPresent()){
            produtoRepository.editar(new Produto(id, produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria()));
        }

        throw new ProdutoNaoEncontrado("Produto " + id + " não encontrado");
    }
}
