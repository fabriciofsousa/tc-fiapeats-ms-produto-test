package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapperImpl;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoProdutoRepositoryJPA;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import java.util.UUID;
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
  @Autowired private PedidoMapperImpl pedidoMapperImpl;

  @Override
  public PedidoResponse salvarPedido(Pedido pedido) {
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoRepositoryImpl-salvarPedido] ");
    if (pedido.getIdProdutos().isEmpty()) {
      return null;
      // executar exception de lista vazia
    }

    PedidoEntity result = pedidoRepositoryJPA.save(pedidoMapper.toPedidoEntity(pedido));

    for (String idProduto : pedido.getIdProdutos()) {
      PedidoProdutoEntity entity;
      entity =
          PedidoProdutoEntity.builder()
              .id(
                  PedidoProdutoEntity.PedidoProdutoId.builder()
                      .idPedido(result.getId())
                      .idProduto(UUID.fromString(idProduto))
                      .build())
              .pedido(result)
              .build();
      pedidoProdutoRepositoryJPA.save(entity);
    }
    return pedidoMapper.toPedidoResponse(pedidoMapper.toPedidoFromEntity(result));
  }
}
