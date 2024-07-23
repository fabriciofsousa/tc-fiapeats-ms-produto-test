package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private ProdutoRepositoryJPA produtoRepositoryJPA;

    @Override
    public ProdutoEntity criar(Produto produto) {
        return produtoRepositoryJPA.save(new ProdutoEntity(produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria(), produto.getFoto()));
    }

    @Override
    public Optional<ProdutoEntity> consultar(Long id) {
        return produtoRepositoryJPA.findById(id);
    }
}
