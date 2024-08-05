package br.com.fiap.fiapeats.core.usecases.pedido;

import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.ports.in.pedido.CriarPedidoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import java.time.LocalDateTime;

public class CriarPedidoUseCaseImpl implements CriarPedidoUseCasePort {

  private final PedidoRepositoryPort pedidoRepositoryPort;

  public CriarPedidoUseCaseImpl(PedidoRepositoryPort pedidoRepositoryPort) {
    this.pedidoRepositoryPort = pedidoRepositoryPort;
  }

  @Override
  public Pedido criarPedido(Pedido pedido) {
    pedido.setDataHoraCriacao(LocalDateTime.now());

    pedido.setIdStatus(1L);
    pedido.setTempoEspera(10);

    return pedidoRepositoryPort.salvarPedido(pedido);
  }
}
