package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ListarPedidosResponse;
import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;
import java.util.ArrayList;
import java.util.List;

public class PedidoPresenter {

  public static CriarPedidoResponse toCriarPedidoResponse(Pedido pedido) {
    return new CriarPedidoResponse(
        pedido.getId().toString(),
        pedido.getCliCpf(),
        pedido.getIdStatus(),
        pedido.getTempoEspera(),
        pedido.getDataHoraCriacao());
  }

  public static List<ListarPedidosResponse> toListarPedidosResponse(List<Pedido> pedidos) {
    List<ListarPedidosResponse> response = new ArrayList<>();

    for (Pedido pedido : pedidos) {
      response.add(
          new ListarPedidosResponse(
              pedido.getId().toString(),
              pedido.getCliCpf(),
              pedido.getIdStatus(),
              pedido.getValor(),
              pedido.getTempoEspera(),
              pedido.getDataHoraCriacao(),
              pedido.getProdutos().stream().map(ProdutoResponse::new).toList()));
    }

    return response;
  }
}
