package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.core.domain.PedidoDTO;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PedidoRepositoryImpl implements PedidoRepositoryPort {
  @Autowired private PedidoMapper pedidoMapper;

  @Override
  public PedidoResponse salvarPedido(PedidoDTO pedidoDTO) {
    return pedidoMapper.toPedidoResponse(pedidoDTO);
  }
}
