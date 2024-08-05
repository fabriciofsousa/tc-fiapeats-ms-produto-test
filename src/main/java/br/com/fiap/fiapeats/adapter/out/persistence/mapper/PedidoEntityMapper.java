package br.com.fiap.fiapeats.adapter.out.persistence.mapper;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import br.com.fiap.fiapeats.core.domain.Categoria;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.domain.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PedidoEntityMapper {

    PedidoEntity toPedidoEntity(Pedido pedido);

    @Mapping(target = "produtos", source = "produtos", qualifiedByName = "mapProdutoEntitiesToProdutos")
    Pedido toPedidoFromEntity(PedidoEntity pedidoEntity);

    @Named("mapProdutoEntitiesToProdutos")
    static List<Produto> mapProdutoEntitiesToProdutos(Set<ProdutoEntity> produtoEntities) {
        return produtoEntities.stream()
                .map(entity -> new Produto(
                        entity.getId(),
                        entity.getNome(),
                        entity.getDescricao(),
                        entity.getValor(),
                        entity.getCategoria() != null ? new Categoria(entity.getCategoria().getId(), entity.getCategoria().getDescricao()) : null,
                        entity.getImagemUrl()
                ))
                .toList();
    }
}
