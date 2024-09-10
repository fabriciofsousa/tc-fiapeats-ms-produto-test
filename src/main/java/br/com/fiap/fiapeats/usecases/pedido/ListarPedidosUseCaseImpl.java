package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.entities.Pedido;
import br.com.fiap.fiapeats.interfaces.in.pedido.ListarPedidosUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.PedidoRepositoryInterface;

import java.util.List;

public class ListarPedidosUseCaseImpl implements ListarPedidosUseCaseInterface {

    private final PedidoRepositoryInterface pedidoRepositoryInterface;

    public ListarPedidosUseCaseImpl(PedidoRepositoryInterface pedidoRepositoryInterface) {
        this.pedidoRepositoryInterface = pedidoRepositoryInterface;
    }

    @Override
    public List<Pedido> listar() {
        return pedidoRepositoryInterface.listarPedidos();
    }
}
