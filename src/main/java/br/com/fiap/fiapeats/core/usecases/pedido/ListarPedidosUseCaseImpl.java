package br.com.fiap.fiapeats.core.usecases.pedido;

import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.ports.in.pedido.ListarPedidosUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;

import java.util.List;

public class ListarPedidosUseCaseImpl implements ListarPedidosUseCasePort {

    private final PedidoRepositoryPort pedidoRepositoryPort;

    public ListarPedidosUseCaseImpl(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepositoryPort.listarPedidos();
    }
}
