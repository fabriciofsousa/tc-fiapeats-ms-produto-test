package br.com.fiap.fiapeats.core.ports.in.pedido;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.Pedido;

public interface CriarPedidoUseCasePort {

  PedidoResponse criarPedido(Pedido pedido);
}
