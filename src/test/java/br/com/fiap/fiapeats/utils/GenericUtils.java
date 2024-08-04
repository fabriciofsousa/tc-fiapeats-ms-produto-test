package br.com.fiap.fiapeats.utils;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Pedido;
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
    pedido.setIdProdutos(List.of("550e8400-e29b-41d4-a716-446655440000"));
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

  public static PedidoProdutoEntity retornaPedidoProdutoEntityValido() {
    Pedido pedido = retornaPedidoValido();
    PedidoEntity pedidoEntity = retornaPedidoEntityValido();
    return PedidoProdutoEntity.builder()
        .id(
            PedidoProdutoEntity.PedidoProdutoId.builder()
                .idPedido(pedidoEntity.getId())
                .idProduto(UUID.fromString(pedido.getIdProdutos().get(0)))
                .build())
        .pedido(pedidoEntity)
        .build();
  }

  public static PedidoResponse retornaPedidoResponseValido() {
    PedidoEntity pedidoEntity = retornaPedidoEntityValido();
    return PedidoResponse.builder()
        .idPedido(pedidoEntity.getId().toString())
        .cliCpf(pedidoEntity.getCliCpf())
        .tempoEspera(pedidoEntity.getTempoEspera())
        .status(pedidoEntity.getIdStatus())
        .dataHoraCriacao(pedidoEntity.getDataHoraCriacao())
        .build();
  }

  public static Pedido pedidoInvalidoSemProdutos() {
    Pedido pedidoSemProdutos = new Pedido();
    pedidoSemProdutos.setCliCpf("12345678900");
    pedidoSemProdutos.setValor(new BigDecimal("100.00"));
    pedidoSemProdutos.setIdStatus(1L);
    pedidoSemProdutos.setDataHoraCriacao(LocalDateTime.now());
    pedidoSemProdutos.setTempoEspera(30);
    pedidoSemProdutos.setIdProdutos(List.of());

    return pedidoSemProdutos;
  }
}
