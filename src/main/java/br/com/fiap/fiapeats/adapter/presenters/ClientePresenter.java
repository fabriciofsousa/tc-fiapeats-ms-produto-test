package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteResponse;
import br.com.fiap.fiapeats.usecases.dtos.IdentificarClienteResponse;

public class ClientePresenter {

    public static CriarClienteResponse toCriarClienteResponse(Cliente cliente) {
        return new CriarClienteResponse(cliente.getNome(),
                cliente.getEmail(),
                cliente.getDocumento()
        );
    }

    public static IdentificarClienteResponse toIdentificarClienteResponse(Cliente cliente) {
        return new IdentificarClienteResponse(cliente.getNome(),
                cliente.getEmail(),
                cliente.getDocumento()
        );
    }

}
