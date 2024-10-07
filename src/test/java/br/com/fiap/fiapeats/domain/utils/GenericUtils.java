package br.com.fiap.fiapeats.domain.utils;

import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.domain.entities.Produto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class GenericUtils {

    public static Pedido retornaPedidoValido() {
        Pedido pedido = new Pedido();
        pedido.setCliCpf("12345678900");
        pedido.setValor(new BigDecimal("100.00"));
        pedido.setIdStatus(1L);
        pedido.setDataHoraCriacao(LocalDateTime.now());
        pedido.setTempoEspera(30);
        pedido.setProdutos(List.of(new Produto(UUID.randomUUID())));
        return pedido;
    }

    public static PedidoEntity retornaPedidoEntityValido() {
        Pedido pedido = retornaPedidoValido();
        return PedidoEntity.builder()
                .id(UUID.randomUUID())
                .cliCpf(pedido.getCliCpf())
                .valor(pedido.getValor())
                .idStatus(pedido.getIdStatus())
                .dataHoraCriacao(pedido.getDataHoraCriacao())
                .tempoEspera(pedido.getTempoEspera())
                .build();
    }

    public static CriarPedidoResponse retornaPedidoResponseValido() {
        PedidoEntity pedidoEntity = retornaPedidoEntityValido();
        return new CriarPedidoResponse(pedidoEntity.getId().toString(),
                pedidoEntity.getCliCpf(),
                pedidoEntity.getIdStatus(),
                pedidoEntity.getTempoEspera(),
                pedidoEntity.getDataHoraCriacao());
    }

    public static Pedido pedidoInvalidoSemProdutos() {
        Pedido pedidoSemProdutos = new Pedido();
        pedidoSemProdutos.setCliCpf("12345678900");
        pedidoSemProdutos.setValor(new BigDecimal("100.00"));
        pedidoSemProdutos.setIdStatus(1L);
        pedidoSemProdutos.setDataHoraCriacao(LocalDateTime.now());
        pedidoSemProdutos.setTempoEspera(30);
        pedidoSemProdutos.setProdutos(List.of());

        return pedidoSemProdutos;
    }
}
