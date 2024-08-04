package br.com.fiap.fiapeats.core.usecases.pedido;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.ports.in.pedido.CriarPedidoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class CriarPedidoUseCaseImpl implements CriarPedidoUseCasePort {

  @Autowired private PedidoRepositoryPort pedidoRepositoryPort;

  @Override
  public PedidoResponse criarPedido(Pedido pedido) {

    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoUseCaseImpl-criarPedido] ");
    pedido.setDataHoraCriacao(LocalDateTime.now());

    pedido.setIdStatus(1L);
    pedido.setTempoEspera(10);

    return pedidoRepositoryPort.salvarPedido(pedido);
  }
}
