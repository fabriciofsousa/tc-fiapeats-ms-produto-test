package br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import java.util.List;
import java.util.UUID;

public interface PedidoRepository {
  Pedido salvarPedido(Pedido pedido);

  List<Pedido> listarPedidos();

  void atualizarStatusPagamentoPedido(Pedido pedido);

  List<Pedido> listarPedidosPorIdStatusPagamento(Long idStatusPagamento);

  Pedido listarPedidoPorId(UUID id);
}
