package br.com.fiap.fiapeats.usecases.pagamento;

import br.com.fiap.fiapeats.domain.entities.PagamentoPedidoExterno;
import br.com.fiap.fiapeats.usecases.exceptions.NotFoundException;
import br.com.fiap.fiapeats.usecases.interfaces.in.pagamento.AtualizarPagamentoUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pagamento.PagamentoGateway;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class AtualizarPagamentoUseCaseImpl implements AtualizarPagamentoUseCase {

  private final PedidoRepositoryGateway pedidoRepositoryGateway;
  private final PagamentoGateway pagamentoGateway;

  private final String STATUS_PAGAMENTO_PEDIDO = "closed";
  private final String TOPICO_PEDIDO = "merchant_order";
  private final String STATUS_PAGAMENTO = "approved";

  public AtualizarPagamentoUseCaseImpl(
      PedidoRepositoryGateway pedidoRepositoryGateway, PagamentoGateway pagamentoGateway) {
    this.pedidoRepositoryGateway = pedidoRepositoryGateway;
    this.pagamentoGateway = pagamentoGateway;
  }

  @Override
  public void atualizar(String idPedidoExterno, String topico) {
    if (topico != null && topico.equals(TOPICO_PEDIDO)) {
      var pagamentoPedido = pagamentoGateway.consultar(idPedidoExterno);
      var pedido =
          pedidoRepositoryGateway.consultarPedidoPorId(
              UUID.fromString(pagamentoPedido.getIdPedido()));
      if (pedido == null) {
        throw new NotFoundException("Id pedido vinculado ao id pedido externo não encontrado");
      }
      log.info("Atualizando status de pagamento do id pedido {}", pagamentoPedido.getIdPedido());
      pedidoRepositoryGateway.atualizarStatusPagamentoPedido(
          pedido, obterStatusPagamento(pagamentoPedido));
    }
  }

  private Integer obterStatusPagamento(PagamentoPedidoExterno pagamentoPedido) {
    if (pagamentoPedido.getStatus().equals(STATUS_PAGAMENTO_PEDIDO)) {
      return pagamentoPedido.getPagamento().get(0).getStatus().equals(STATUS_PAGAMENTO) ? 1 : 2;
    }
    return null;
  }
}
