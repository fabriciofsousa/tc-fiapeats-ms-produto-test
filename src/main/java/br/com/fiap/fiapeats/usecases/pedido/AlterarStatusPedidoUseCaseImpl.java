package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.AlterarStatusPedidoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.UUID;

public class AlterarStatusPedidoUseCaseImpl implements AlterarStatusPedidoUseCase {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    public AlterarStatusPedidoUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    }

    @Override
    public Pedido alterarStatusPedido(UUID id, Long status) {
        var pedido = pedidoRepositoryGateway.listarPedidoPorId(id);
        if (pedido == null) {
            throw new NotFoundException("Pedido não encontrado.");
        }
        pedido.getStatusPedido().setId(status);
        return pedidoRepositoryGateway.salvarPedido(pedido);
    }
}