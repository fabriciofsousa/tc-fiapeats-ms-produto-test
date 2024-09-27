package br.com.fiap.fiapeats.domain.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.domain.entities.Pedido;

public interface CriarPedidoUseCase {
    Pedido criarPedido(CriarPedidoDTO criarPedidoDTO);
}
