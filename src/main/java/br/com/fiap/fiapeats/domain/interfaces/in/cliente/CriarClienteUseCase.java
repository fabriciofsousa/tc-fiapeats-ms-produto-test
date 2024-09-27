package br.com.fiap.fiapeats.domain.interfaces.in.cliente;

import br.com.fiap.fiapeats.domain.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.domain.entities.Cliente;

public interface CriarClienteUseCase {
    Cliente criar(CriarClienteDTO criarClienteDTO);
}
