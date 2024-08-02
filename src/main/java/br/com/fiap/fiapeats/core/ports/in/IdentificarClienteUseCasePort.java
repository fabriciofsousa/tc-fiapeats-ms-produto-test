package br.com.fiap.fiapeats.core.ports.in;

import br.com.fiap.fiapeats.core.domain.Cliente;

public interface IdentificarClienteUseCasePort {
    Cliente identificar(String documento);
}
