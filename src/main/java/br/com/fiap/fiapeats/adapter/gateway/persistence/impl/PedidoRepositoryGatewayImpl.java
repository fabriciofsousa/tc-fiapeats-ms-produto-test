package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.PedidoRepository;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.List;
import java.util.UUID;

public class PedidoRepositoryGatewayImpl implements PedidoRepositoryGateway {

    private final PedidoRepository pedidoRepository;

    public PedidoRepositoryGatewayImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        return pedidoRepository.salvarPedido(pedido);
    }

    @Override
    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarPedidos();
    }

    @Override
    public Pedido consultarPedidoPorId(UUID id) {
        return pedidoRepository.consultarPedidoPorId(id);
    }


}
