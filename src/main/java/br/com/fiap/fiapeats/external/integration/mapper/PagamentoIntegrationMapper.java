package br.com.fiap.fiapeats.external.integration.mapper;

import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.external.integration.feign.response.CriarPagamentoPedidoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PagamentoIntegrationMapper {

  Pagamento toPagamento(CriarPagamentoPedidoResponse criarPagamentoPedidoResponse);
}
