package br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces;

import br.com.fiap.fiapeats.domain.entities.Pedido;

import java.util.List;

public interface PedidoRepository {
    Pedido salvarPedido(Pedido pedido);

    List<Pedido> listarPedidos();
}
