package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Pedido;

public interface PedidoRepositoryPort {
  Pedido salvarPedido(Pedido pedido);
}
