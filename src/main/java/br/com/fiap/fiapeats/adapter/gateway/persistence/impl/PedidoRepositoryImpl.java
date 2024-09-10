package br.com.fiap.fiapeats.adapter.gateway.persistence.impl;

import br.com.fiap.fiapeats.adapter.gateway.persistence.mapper.PedidoEntityMapper;
import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.PedidoEntity;
import br.com.fiap.fiapeats.adapter.gateway.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.entities.Pedido;
import br.com.fiap.fiapeats.interfaces.out.pedido.PedidoRepositoryInterface;
import br.com.fiap.fiapeats.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PedidoRepositoryImpl implements PedidoRepositoryInterface {

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
