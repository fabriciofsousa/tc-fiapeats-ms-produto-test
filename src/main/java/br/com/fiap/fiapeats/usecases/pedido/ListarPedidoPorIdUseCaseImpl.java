package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidoPorIdUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.UUID;

public class ListarPedidoPorIdUseCaseImpl implements ListarPedidoPorIdUseCase {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    public ListarPedidoPorIdUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    }

    @Override
    public Pedido listarPedidoPorId(UUID id) {
        var pedido = pedidoRepositoryGateway.listarPedidoPorId(id);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado!");
        }
        return pedido;
    }

}