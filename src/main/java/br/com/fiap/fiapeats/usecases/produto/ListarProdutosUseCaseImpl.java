package br.com.fiap.fiapeats.usecases.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.interfaces.in.produto.ListarProdutosUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.produto.ProdutoRepositoryGateway;

import java.util.List;

public class ListarProdutosUseCaseImpl implements ListarProdutosUseCase {

    private final ProdutoRepositoryGateway produtoRepositoryGateway;

    public ListarProdutosUseCaseImpl(ProdutoRepositoryGateway produtoRepositoryGateway) {
        this.produtoRepositoryGateway = produtoRepositoryGateway;
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepositoryGateway.listarProdutos();
    }
}
