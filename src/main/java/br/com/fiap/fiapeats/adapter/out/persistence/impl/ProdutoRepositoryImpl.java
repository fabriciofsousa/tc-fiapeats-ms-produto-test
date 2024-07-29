package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoRepositoryImpl implements ProdutoRepository {

    @Autowired
    private ProdutoRepositoryJPA produtoRepositoryJPA;

    @Override
    public ProdutoEntity criar(Produto produto) {
        return produtoRepositoryJPA.save(new ProdutoEntity(produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria(), produto.getFoto()));
    }

    @Override
    public Optional<ProdutoEntity> consultar(UUID id) {
        return produtoRepositoryJPA.findById(id);
    }

    @Override
    public void editar(Produto produto) {
        produtoRepositoryJPA.save(new ProdutoEntity(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getCategoria(), produto.getFoto()));
    }
}
