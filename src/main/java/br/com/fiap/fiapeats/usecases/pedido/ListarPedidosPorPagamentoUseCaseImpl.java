package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosPorPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.List;

public class ListarPedidosPorPagamentoUseCaseImpl implements ListarPedidosPorPagamentoUseCase {

    private final PedidoRepositoryGateway pedidoRepositoryGateway;

    public ListarPedidosPorPagamentoUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
        this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    }

    @Override
    public List<Pedido> listarPedidoPorIdStatusPagamento(Long idStatusPagamento) {
        var pedido = pedidoRepositoryGateway.listarPedidosPorIdStatusPagamento(idStatusPagamento);
        if (pedido == null || pedido.isEmpty()) {
            throw new NotFoundException("Não há pedidos com o status de pagamento "+ idStatusPagamento);
        }
        return pedido;
    }
}