package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.domain.Produto;

public interface ProdutoRepositoryPort {
  Produto salvar(Produto produto);
}
