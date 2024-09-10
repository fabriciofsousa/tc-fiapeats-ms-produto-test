package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.entities.Pedido;
import br.com.fiap.fiapeats.interfaces.in.pedido.CriarPedidoUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.out.pedido.PedidoRepositoryInterface;
import java.time.LocalDateTime;

public class CriarPedidoUseCaseImpl implements CriarPedidoUseCaseInterface {

  private final PedidoRepositoryInterface pedidoRepositoryInterface;

  public CriarPedidoUseCaseImpl(PedidoRepositoryInterface pedidoRepositoryInterface) {
    this.pedidoRepositoryInterface = pedidoRepositoryInterface;
  }

  @Override
  public Pedido criarPedido(Pedido pedido) {
    pedido.setDataHoraCriacao(LocalDateTime.now());

    pedido.setIdStatus(1L);
    pedido.setTempoEspera(10);

    return pedidoRepositoryInterface.salvarPedido(pedido);
  }
}
