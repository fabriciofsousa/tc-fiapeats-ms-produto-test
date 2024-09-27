package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.PedidoPresenter;
import br.com.fiap.fiapeats.domain.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.domain.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.domain.dtos.ListarPedidosResponse;
import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.domain.interfaces.in.pedido.CriarPedidoUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.pedido.ListarPedidosUseCase;

import java.util.List;

public class PedidoController {

    private final CriarPedidoUseCase criarPedidoUseCase;

    private final ListarPedidosUseCase listarPedidosUseCase;

    public PedidoController(CriarPedidoUseCase criarPedidoUseCase, ListarPedidosUseCase listarPedidosUseCase) {
        this.criarPedidoUseCase = criarPedidoUseCase;
        this.listarPedidosUseCase = listarPedidosUseCase;
    }

    public CriarPedidoResponse criarNovoPedido(CriarPedidoDTO criarPedidoDTO) {
        Pedido pedido = criarPedidoUseCase.criarPedido(criarPedidoDTO);

        return PedidoPresenter.toCriarPedidoResponse(pedido);
    }

    public List<ListarPedidosResponse> listarPedidos() {
        List<Pedido> pedidos = listarPedidosUseCase.listar();

        return PedidoPresenter.toListarPedidosResponse(pedidos);
    }

}
