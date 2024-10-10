package br.com.fiap.fiapeats.usecases.interfaces.out.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import java.util.List;
import java.util.UUID;

public interface PedidoRepositoryGateway {
  Pedido salvarPedido(Pedido pedido);

  List<Pedido> listarPedidos();

  void atualizarStatusPagamentoPedido(Pedido pedido);

  List<Pedido> listarPedidosPorIdStatusPagamento(Long idStatusPagamento);

  Pedido listarPedidoPorId(UUID id);
}
