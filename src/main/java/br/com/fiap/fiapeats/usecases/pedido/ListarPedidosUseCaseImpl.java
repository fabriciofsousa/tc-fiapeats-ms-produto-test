package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.List;

public class ListarPedidosUseCaseImpl implements ListarPedidosUseCase {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    public ListarPedidosUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepositoryGateway.listarPedidos();
    }
}
