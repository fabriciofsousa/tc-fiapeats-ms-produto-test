package br.com.fiap.fiapeats.external.integration.impl;

import br.com.fiap.fiapeats.adapter.gateway.integration.interfaces.PagamentoIntegration;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.external.integration.feign.AutenticacaoFeign;
import br.com.fiap.fiapeats.external.integration.feign.PedidoFeign;
import br.com.fiap.fiapeats.external.integration.feign.request.CriarAutenticacaoRequest;
import br.com.fiap.fiapeats.external.integration.feign.request.CriarPagamentoPedidoRequest;
import br.com.fiap.fiapeats.external.integration.feign.request.ProdutosPedidoRequest;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class PagamentoIntegrationImpl implements PagamentoIntegration {

    private final AutenticacaoFeign autenticacaoFeign;
    private final PedidoFeign pedidoFeign;

    public PagamentoIntegrationImpl(AutenticacaoFeign autenticacaoFeign, PedidoFeign pedidoFeign) {
        this.autenticacaoFeign = autenticacaoFeign;
        this.pedidoFeign = pedidoFeign;
    }


    @Override
    public Pagamento criarCodigoPagamento(Pedido pedido, Pagamento pagamento) {

        var listaProdutos = pedido.getProdutos().stream().map(p -> new ProdutosPedidoRequest(p.getId().toString(), p.getCategoria().getDescricao(),
                        p.getNome(), p.getDescricao(), p.getValor(), p.getValor())).toList();
        var retorno = pedidoFeign.criarPedido(obterToken(),
                new CriarPagamentoPedidoRequest(pedido.getId().toString(), pagamento.getUrlNotificacao(),
                        valorTotalProdutos(listaProdutos), listaProdutos));

        return new Pagamento(pagamento.getIdPedido(), pagamento.getUrlNotificacao(), retorno.getCodigoQr());
    }

    private BigDecimal valorTotalProdutos(List<ProdutosPedidoRequest> listaProdutos) {
        BigDecimal valor = new BigDecimal(0);
        for (ProdutosPedidoRequest produto : listaProdutos){
            valor = valor.add(produto.getValorItem());
        }
        return valor;
    }

    private final String obterToken(){
        var responseToken = autenticacaoFeign.obterToken(new CriarAutenticacaoRequest());
        return responseToken.getTokenType().concat(" " + responseToken.getAccessToken());
    }




}
