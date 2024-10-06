package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteResponse;
import br.com.fiap.fiapeats.usecases.dtos.CriarPagamentoResponse;
import br.com.fiap.fiapeats.usecases.dtos.IdentificarClienteResponse;

public class PagamentoPresenter {

    public static CriarPagamentoResponse toCriarPagamentoResponse(Pagamento pagamento) {
        return new CriarPagamentoResponse(pagamento.getCodigoQR());
    }

}
