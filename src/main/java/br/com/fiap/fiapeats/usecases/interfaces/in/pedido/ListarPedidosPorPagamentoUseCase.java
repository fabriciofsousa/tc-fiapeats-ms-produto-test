package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;

import java.util.List;

public interface ListarPedidosPorPagamentoUseCase {

    List<Pedido> listarPedidoPorIdStatusPagamento(Long idStatusPagamento);
}
