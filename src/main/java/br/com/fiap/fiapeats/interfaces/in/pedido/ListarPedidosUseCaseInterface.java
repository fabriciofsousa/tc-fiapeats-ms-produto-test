package br.com.fiap.fiapeats.interfaces.in.pedido;

import br.com.fiap.fiapeats.entities.Pedido;

import java.util.List;

public interface ListarPedidosUseCaseInterface {

    List<Pedido> listar();
}
