package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.mapper.ProdutoEntityMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoRepositoryImpl implements ProdutoRepositoryPort {

    private final ProdutoEntityMapper produtoEntityMapper;
    private final ProdutoRepositoryJPA produtoRepositoryJPA;

    public ProdutoRepositoryImpl(
            ProdutoEntityMapper produtoEntityMapper, ProdutoRepositoryJPA produtoRepositoryJPA) {
        this.produtoEntityMapper = produtoEntityMapper;
        this.produtoRepositoryJPA = produtoRepositoryJPA;
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
}