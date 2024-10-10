package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;

import java.util.UUID;

public interface AlterarStatusPedidoUseCase {

    Pedido alterarStatusPedido(UUID id, Long status);
}
