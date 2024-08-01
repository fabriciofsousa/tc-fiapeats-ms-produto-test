package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.Pedido;
import java.util.UUID;

public interface PedidoUseCasePort {

  PedidoResponse criarPedido(Pedido pedido);

  void consultarPedido(UUID id);
}
