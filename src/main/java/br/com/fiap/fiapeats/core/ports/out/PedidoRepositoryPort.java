package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.core.domain.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {
  Pedido salvarPedido(Pedido pedido);
  List<Pedido> listarPedidos();
}
