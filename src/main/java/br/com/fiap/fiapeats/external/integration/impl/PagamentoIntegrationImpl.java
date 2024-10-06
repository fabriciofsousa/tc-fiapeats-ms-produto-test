package br.com.fiap.fiapeats.external.integration.impl;

import br.com.fiap.fiapeats.adapter.gateway.integration.interfaces.PagamentoIntegration;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.external.integration.feign.AutenticacaoFeign;
import br.com.fiap.fiapeats.external.integration.feign.PedidoFeign;
import br.com.fiap.fiapeats.external.integration.feign.request.CriarAutenticacaoRequest;
import br.com.fiap.fiapeats.external.integration.feign.request.CriarPagamentoPedidoRequest;
import br.com.fiap.fiapeats.external.integration.feign.request.ProdutosPedidoRequest;
import br.com.fiap.fiapeats.external.integration.mapper.PagamentoIntegrationMapper;
import java.math.BigDecimal;
import java.util.List;

public class PagamentoIntegrationImpl implements PagamentoIntegration {

  private final AutenticacaoFeign autenticacaoFeign;
  private final PedidoFeign pedidoFeign;
  private final PagamentoIntegrationMapper pagamentoIntegrationMapper;

  public PagamentoIntegrationImpl(
      AutenticacaoFeign autenticacaoFeign,
      PedidoFeign pedidoFeign,
      PagamentoIntegrationMapper pagamentoIntegrationMapper) {
    this.autenticacaoFeign = autenticacaoFeign;
    this.pedidoFeign = pedidoFeign;
    this.pagamentoIntegrationMapper = pagamentoIntegrationMapper;
  }

  @Override
  public Pagamento criarCodigoPagamento(Pedido pedido, Pagamento pagamento) {
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
        pedidoFeign.criarPedido(
            obterToken(),
            new CriarPagamentoPedidoRequest(
                pedido.getId().toString(),
                pagamento.getUrlNotificacao(),
                valorTotalProdutos(produtos),
                produtos)));
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
