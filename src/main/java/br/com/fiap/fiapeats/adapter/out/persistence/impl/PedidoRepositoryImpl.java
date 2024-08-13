package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.mapper.PedidoEntityMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PedidoRepositoryImpl implements PedidoRepositoryPort {

    @Autowired
    private PedidoEntityMapper pedidoMapper;

    @Autowired
    private PedidoRepositoryJPA pedidoRepositoryJPA;

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
}
