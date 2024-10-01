package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;

public interface CriarProdutoUseCase {
    Produto criar(CriarProdutoDTO criarProdutoDTO);
}
