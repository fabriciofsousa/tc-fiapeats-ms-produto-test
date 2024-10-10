package br.com.fiap.fiapeats.usecases.pagamento;

import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.usecases.dtos.CriarPagamentoDTO;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.pagamento.CriarPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pagamento.PagamentoGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

public class CriarPagamentoUseCaseImpl implements CriarPagamentoUseCase {

  private final PedidoRepositoryGateway pedidoRepositoryGateway;
  private final PagamentoGateway pagamentoGateway;

  public CriarPagamentoUseCaseImpl(
      PedidoRepositoryGateway pedidoRepositoryGateway, PagamentoGateway pagamentoGateway) {
    this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    this.pagamentoGateway = pagamentoGateway;
  }

  @Override
  public Pagamento criar(CriarPagamentoDTO criarPagamentoDTO) {
    var pedido = pedidoRepositoryGateway.listarPedidoPorId(criarPagamentoDTO.getIdPedido());
    if (pedido == null) {
      throw new NotFoundException("Id pedido não encontrado");
    }

    return pagamentoGateway.criar(
        pedido,
        new Pagamento(
            criarPagamentoDTO.getIdPedido(), criarPagamentoDTO.getUrlNotificacao(), null));
  }
}
