package br.com.fiap.fiapeats.core.ports.in.pedido;

import br.com.fiap.fiapeats.core.domain.Pedido;

public interface CriarPedidoUseCasePort {

  Pedido criarPedido(Pedido pedido);
}
