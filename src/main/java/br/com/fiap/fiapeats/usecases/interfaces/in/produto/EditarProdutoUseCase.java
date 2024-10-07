package br.com.fiap.fiapeats.usecases.interfaces.in.produto;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;

public interface EditarProdutoUseCase {
  Produto editar(EditarProdutoDTO editarProdutoDTO);
}
