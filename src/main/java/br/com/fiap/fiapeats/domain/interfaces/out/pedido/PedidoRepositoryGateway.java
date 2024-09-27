package br.com.fiap.fiapeats.domain.interfaces.out.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;

import java.util.List;

public interface PedidoRepositoryGateway {
    Pedido salvarPedido(Pedido pedido);

    List<Pedido> listarPedidos();
}
