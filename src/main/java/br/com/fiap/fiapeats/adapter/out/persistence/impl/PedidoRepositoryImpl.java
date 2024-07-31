package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.PedidoDTO;
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

  @Override
  public PedidoResponse salvarPedido(PedidoDTO pedidoDTO) {
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoRepositoryImpl-salvarPedido] ");
    return pedidoMapper.toPedidoResponse(
        pedidoMapper.toPedidoDTO(pedidoRepositoryJPA.save(pedidoMapper.toPedidoEntity(pedidoDTO))));
  }
}
