package br.com.fiap.fiapeats.usecases.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.interfaces.in.pedido.ListarPedidosUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.out.pedido.PedidoRepositoryGateway;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListarPedidosUseCaseImpl implements ListarPedidosUseCase {

  private final PedidoRepositoryGateway pedidoRepositoryGateway;

  public ListarPedidosUseCaseImpl(PedidoRepositoryGateway pedidoRepositoryGateway) {
    this.pedidoRepositoryGateway = pedidoRepositoryGateway;
  }

  @Override
  public List<Pedido> listar() {
    List<Pedido> pedidos = pedidoRepositoryGateway.listarPedidos();

    return pedidos.stream()
            .filter(pedido -> !pedido.getStatusPedido().getId().equals(5L)) // Remover pedidos com status "Finalizado"
            .collect(Collectors.groupingBy(pedido -> {
              // Setta prioridades
              switch (pedido.getStatusPedido().getId().intValue()) {
                case 4: //Status Pronto
                  return 1;
                case 3: // Status Em preparação
                  return 2;
                case 2: // Status Recebido
                  return 3;
                default:
                  return 4; // prioridade 4
              }
            }))
            .entrySet().stream()
            .sorted(Map.Entry.comparingByKey()) // Ordena pelo status
            .flatMap(entry -> entry.getValue().stream()
                    .sorted(Comparator.comparing(Pedido::getDataHoraCriacao)) // Ordena por data (mais antigo primeiro)
            )
            .collect(Collectors.toList());
  }
}
