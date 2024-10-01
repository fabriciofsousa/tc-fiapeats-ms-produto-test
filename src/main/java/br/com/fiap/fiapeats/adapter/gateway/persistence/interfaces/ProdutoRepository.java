package br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces;

import br.com.fiap.fiapeats.domain.entities.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salvar(Produto produto);

    Produto editar(Produto produto);

    Produto consultarPorId(UUID id);

    void excluir(UUID id);

    List<Produto> listarProdutos();

    List<Produto> listarProdutosPorcategoria(Long idCategoria);
}
