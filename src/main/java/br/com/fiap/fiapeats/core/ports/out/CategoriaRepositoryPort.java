package br.com.fiap.fiapeats.core.ports.out;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.domain.Pedido;

public interface CategoriaRepositoryPort {
  Categoria consultar(Categoria categoria);
}
