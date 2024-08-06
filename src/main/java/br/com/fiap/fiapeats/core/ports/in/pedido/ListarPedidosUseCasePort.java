package br.com.fiap.fiapeats.core.ports.in.pedido;

import br.com.fiap.fiapeats.core.domain.Pedido;

import java.util.List;

public interface ListarPedidosUseCasePort {

    List<Pedido> listar();
}
