package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoID;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoProdutoRepositoryJPA;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PedidoRepositoryImpl implements PedidoRepositoryPort {
  @Autowired private PedidoMapper pedidoMapper;
  @Autowired private PedidoRepositoryJPA pedidoRepositoryJPA;
  @Autowired private PedidoProdutoRepositoryJPA pedidoProdutoRepositoryJPA;

  @Override
  public PedidoResponse salvarPedido(Pedido pedido) {
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoRepositoryImpl-salvarPedido] ");

    PedidoResponse resp =
        pedidoMapper.toPedidoResponse(
            pedidoMapper.toPedido(
                pedidoRepositoryJPA.save(pedidoMapper.toPedidoEntity(pedido))));

    for (String idProduto : pedido.getIdProdutos()) {
      pedidoProdutoRepositoryJPA.save(
          PedidoProdutoEntity.builder()
              .id(
                  PedidoProdutoID.builder()
                      .idPedido(resp.getIdPedido())
                      .idProduto(idProduto)
                      .build())
              .build());
    }

    return resp;
  }
}
