package br.com.fiap.fiapeats.external.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.PedidoRepository;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.domain.utils.Constants;
import br.com.fiap.fiapeats.external.persistence.mapper.PedidoEntityMapper;
import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;
import br.com.fiap.fiapeats.external.persistence.repository.PedidoRepositoryJPA;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PedidoRepositoryImpl implements PedidoRepository {

  @Autowired private PedidoEntityMapper pedidoMapper;

  @Autowired private PedidoRepositoryJPA pedidoRepositoryJPA;

  @Override
  public Pedido salvarPedido(Pedido pedido) {
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoRepositoryImpl-salvarPedido] ");

    PedidoEntity result = pedidoRepositoryJPA.save(pedidoMapper.toPedidoEntity(pedido));
    return pedidoMapper.toPedidoFromEntity(result);
  }

  @Override
  public List<Pedido> listarPedidos() {
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoRepositoryImpl-listarPedidos] ");

    List<PedidoEntity> result = pedidoRepositoryJPA.findAll();
    return pedidoMapper.toListaPedidos(result);
  }

  @Override
  public void atualizarStatusPagamentoPedido(Pedido pedido) {
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "[PedidoRepositoryImpl-atualizarStatusPagamentoPedido] ");
    log.info("Atualizando status de pagamento do id pedido {}", pedido.getId());
    var pedidoAtualizado = pedidoMapper.toPedidoEntity(pedido);
    pedidoRepositoryJPA.save(pedidoAtualizado);
  }

  @Override
  public List<Pedido> listarPedidosPorIdStatusPagamento(Long idStatusPagamento) {
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "[PedidoRepositoryImpl-listarPedidosPorIdStatusPagamento] ");
    return pedidoMapper.toListaPedidos(pedidoRepositoryJPA.findAllByStatusPagamentoId(idStatusPagamento));
  }

  @Override
  public Pedido listarPedidoPorId(UUID id) {
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "[PedidoRepositoryImpl-listarPedidosPorId] ");
    return pedidoRepositoryJPA.findById(id).map(pedidoMapper::toPedidoFromEntity).orElse(null);
  }
}
