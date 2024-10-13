package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;

import java.util.UUID;

public interface ListarPedidoPorIdUseCase {

    Pedido listarPedidoPorId(UUID id);
}
