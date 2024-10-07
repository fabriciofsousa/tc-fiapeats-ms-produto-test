package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoResponse;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;

import java.util.List;

public class ProdutoPresenter {
    public static CriarProdutoResponse toCriarProdutoResponse(Produto produto) {
        return new CriarProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getCategoria().getDescricao(),
                produto.getImagemUrl());
    }

    public static EditarProdutoResponse toEditarProdutoResponse(Produto produto) {
        return new EditarProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getCategoria().getDescricao(),
                produto.getImagemUrl());
    }

    public static List<ProdutoResponse> toProdutosResponse(List<Produto> produtos) {
        return produtos.stream()
                .map(ProdutoResponse::new)
                .toList();
    }
}
