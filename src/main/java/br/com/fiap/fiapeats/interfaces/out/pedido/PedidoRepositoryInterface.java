package br.com.fiap.fiapeats.interfaces.out.pedido;

import br.com.fiap.fiapeats.entities.Pedido;

import java.util.List;

public interface PedidoRepositoryInterface {
  Pedido salvarPedido(Pedido pedido);
  List<Pedido> listarPedidos();
}
