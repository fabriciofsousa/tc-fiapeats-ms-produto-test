package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.PedidoDTO;
import br.com.fiap.fiapeats.core.ports.in.PedidoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class PedidoUseCaseImpl implements PedidoUseCasePort {

  @Autowired private PedidoRepositoryPort pedidoRepositoryPort;

  @Override
  public PedidoResponse criarPedido(PedidoDTO pedidoDTO) {

    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoUseCaseImpl-criarPedido] ");
    pedidoDTO.setDataHoraCriacao(LocalDateTime.now());

    pedidoDTO.setIdStatus(1L);
    pedidoDTO.setTempoEspera(10);

    return pedidoRepositoryPort.salvarPedido(pedidoDTO);
  }

  @Override
  public void consultarPedido(UUID id) {}
}
