package br.com.fiap.fiapeats.external.integration.impl;

import br.com.fiap.fiapeats.adapter.gateway.integration.interfaces.PagamentoIntegration;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.domain.entities.PagamentoPedidoExterno;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.domain.utils.Constants;
import br.com.fiap.fiapeats.external.integration.feign.AutenticacaoFeign;
import br.com.fiap.fiapeats.external.integration.feign.PedidoFeign;
import br.com.fiap.fiapeats.external.integration.feign.request.CriarAutenticacaoRequest;
import br.com.fiap.fiapeats.external.integration.feign.request.CriarPagamentoPedidoRequest;
import br.com.fiap.fiapeats.external.integration.feign.request.ProdutosPedidoRequest;
import br.com.fiap.fiapeats.external.integration.mapper.PagamentoIntegrationMapper;
import br.com.fiap.fiapeats.external.integration.mapper.PagamentoPedidoIntegrationMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class PagamentoIntegrationImpl implements PagamentoIntegration {

  private final AutenticacaoFeign autenticacaoFeign;
  private final PedidoFeign pedidoFeign;
  private final PagamentoIntegrationMapper pagamentoIntegrationMapper;
  private final PagamentoPedidoIntegrationMapper pagamentoPedidoIntegrationMapper;

  public PagamentoIntegrationImpl(
      AutenticacaoFeign autenticacaoFeign,
      PedidoFeign pedidoFeign,
      PagamentoIntegrationMapper pagamentoIntegrationMapper,
      PagamentoPedidoIntegrationMapper pagamentoPedidoIntegrationMapper) {
    this.autenticacaoFeign = autenticacaoFeign;
    this.pedidoFeign = pedidoFeign;
    this.pagamentoIntegrationMapper = pagamentoIntegrationMapper;
    this.pagamentoPedidoIntegrationMapper = pagamentoPedidoIntegrationMapper;
  }

  @Override
  public Pagamento criarCodigoPagamento(Pedido pedido, Pagamento pagamento) {
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "[PagamentoIntegrationImpl-criarCodigoPagamento] ");

    var produtos =
        pedido.getProdutos().stream()
            .map(
                p ->
                    new ProdutosPedidoRequest(
                        p.getId().toString(),
                        p.getCategoria().getDescricao(),
                        p.getNome(),
                        p.getDescricao(),
                        p.getValor(),
                        p.getValor()))
            .toList();

    return pagamentoIntegrationMapper.toPagamento(
        pedidoFeign.criar(
            obterToken(),
            new CriarPagamentoPedidoRequest(
                pedido.getId().toString(),
                pagamento.getUrlNotificacao(),
                valorTotalProdutos(produtos),
                produtos)));
  }

  @Override
  public PagamentoPedidoExterno consultarStatusPagamentoPedido(String idPedidoExterno) {
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "[PagamentoIntegrationImpl-consultarStatusPagamentoPedido] ");
    return pagamentoPedidoIntegrationMapper.toPedido(
        pedidoFeign.consultar(obterToken(), idPedidoExterno));
  }

  private BigDecimal valorTotalProdutos(List<ProdutosPedidoRequest> listaProdutos) {
    BigDecimal valor = new BigDecimal(0);
    for (ProdutosPedidoRequest produto : listaProdutos) {
      valor = valor.add(produto.getValorItem());
    }
    return valor;
  }

  private String obterToken() {
    var responseToken = autenticacaoFeign.obterToken(new CriarAutenticacaoRequest());
    return responseToken.getTokenType().concat(" " + responseToken.getAccessToken());
  }
}
