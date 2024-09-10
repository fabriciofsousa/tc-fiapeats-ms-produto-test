package br.com.fiap.fiapeats.adapter.controller.mapper;

import br.com.fiap.fiapeats.adapter.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.CriarPedidoResponse;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.ListarPedidosResponse;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.ProdutoResponse;
import br.com.fiap.fiapeats.entities.Pedido;
import br.com.fiap.fiapeats.entities.Produto;

import java.util.List;
import java.util.UUID;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    @Named("mapIdsToProdutos")
    static List<Produto> mapIdsToProdutos(List<UUID> ids) {
        return ids.stream().map(Produto::new).toList();
    }

    static ProdutoResponse map(Produto produto) {
        return new ProdutoResponse(produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoria().getDescricao(),
                produto.getValor(),
                produto.getImagemUrl());
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "idStatus", ignore = true)
    @Mapping(target = "dataHoraCriacao", ignore = true)
    @Mapping(target = "tempoEspera", ignore = true)
    @Mapping(target = "produtos", source = "idProdutos", qualifiedByName = "mapIdsToProdutos")
    Pedido toPedidoFromRequest(PedidoRequest pedidoRequest);

    @Mapping(target = "idPedido", source = "id")
    @Mapping(target = "status", source = "idStatus")
    CriarPedidoResponse toPedidoResponse(Pedido pedido);

    @Mapping(target = "produtos", source = "produtos")
    List<ListarPedidosResponse> toListarPedidosResponse(List<Pedido> pedidos);

    List<ProdutoResponse> mapProdutosToProdutoResponses(List<Produto> produtos);

    //ProdutoResponse map(Produto produto);
}
