package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;

import java.util.List;

public interface ListarPedidosUseCase {

    List<Pedido> listar();
}
