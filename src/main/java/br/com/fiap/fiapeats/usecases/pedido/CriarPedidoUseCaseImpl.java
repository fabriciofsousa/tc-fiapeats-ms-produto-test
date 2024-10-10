package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.domain.entities.StatusPagamento;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.CriarPedidoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class CriarPedidoUseCaseImpl implements CriarPedidoUseCase {

  private final PedidoRepositoryGateway pedidoRepositoryGateway;

  public CriarPedidoUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
    this.pedidoRepositoryGateway = pedidoRepositoryGateway;
  }

  @Override
  public Pedido criarPedido(CriarPedidoDTO criarPedidoDTO) {
    Pedido pedido = new Pedido();

    pedido.setProdutos(mapIdsToProdutos(criarPedidoDTO.getIdProdutos()));
    pedido.setCliCpf(criarPedidoDTO.getCliCpf());
    pedido.setValor(criarPedidoDTO.getValor());

    pedido.setDataHoraCriacao(LocalDateTime.now());

    pedido.getStatusPedido().setId(1L);
    pedido.setTempoEspera(10);
    pedido.getStatusPagamento().setId(1L);

    return pedidoRepositoryGateway.salvarPedido(pedido);
  }

  private List<Produto> mapIdsToProdutos(List<UUID> ids) {
    return ids.stream().map(Produto::new).toList();
  }
}
