package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.ProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarProdutoUseCase implements ProdutoUseCasePort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void criar(Produto produto) {
        produtoRepository.criar(produto);
    }

    @Override
    public Produto consultar(Long id) {

        Optional<ProdutoEntity> produto = produtoRepository.consultar(id);

        return produto.map(produtoEntity -> new Produto(produtoEntity.getId(),
                produtoEntity.getNome(),
                produtoEntity.getDescricao(),
                produtoEntity.getValor(),
                produtoEntity.getCategoria(),
                produtoEntity.getFoto())).orElseGet(Produto::new);

    }
}
