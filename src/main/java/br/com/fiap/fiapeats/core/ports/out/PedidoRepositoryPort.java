package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.PedidoDTO;

public interface PedidoRepositoryPort {
  PedidoResponse salvarPedido(PedidoDTO pedidoDTO);
}
