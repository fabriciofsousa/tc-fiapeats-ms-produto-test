package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.ProdutoPresenter;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.*;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.*;

import java.util.List;
import java.util.UUID;

public class ProdutoController {

    private final CriarProdutoUseCase criarProdutoUseCase;

    private final EditarProdutoUseCase editarProdutoUseCase;

    private final ExcluirProdutoUseCase excluirProdutoUseCase;

    private final ListarProdutosUseCase listarProdutos;

    private final ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase;

    public ProdutoController(CriarProdutoUseCase criarProdutoUseCase,
                             EditarProdutoUseCase editarProdutoUseCase,
                             ExcluirProdutoUseCase excluirProdutoUseCase,
                             ListarProdutosUseCase listarProdutos,
                             ListarProdutosPorCategoriaUseCase listarProdutosPorCategoriaUseCase) {
        this.criarProdutoUseCase = criarProdutoUseCase;
        this.editarProdutoUseCase = editarProdutoUseCase;
        this.excluirProdutoUseCase = excluirProdutoUseCase;
        this.listarProdutos = listarProdutos;
        this.listarProdutosPorCategoriaUseCase = listarProdutosPorCategoriaUseCase;
    }

    public CriarProdutoResponse criarProduto(CriarProdutoDTO criarProdutoDTO) {
        Produto produto = criarProdutoUseCase.criar(criarProdutoDTO);

        return ProdutoPresenter.toCriarProdutoResponse(produto);
    }

    public EditarProdutoResponse editarProduto(EditarProdutoDTO editarProdutoDTO) {
        Produto produto = editarProdutoUseCase.editar(editarProdutoDTO);

        return ProdutoPresenter.toEditarProdutoResponse(produto);
    }

    public void removerProduto(UUID id) {
        excluirProdutoUseCase.excluir(id);
    }

    public List<ProdutoResponse> listarTodosProdutos() {
        List<Produto> produtos = listarProdutos.listarProdutos();

        return ProdutoPresenter.toProdutosResponse(produtos);
    }

    public List<ProdutoResponse> consultarProdutoPorCategoria(String idCategoria) {
        List<Produto> produtos = listarProdutosPorCategoriaUseCase.listarProdutosPorCategoria(idCategoria);

        return ProdutoPresenter.toProdutosResponse(produtos);
    }
}
