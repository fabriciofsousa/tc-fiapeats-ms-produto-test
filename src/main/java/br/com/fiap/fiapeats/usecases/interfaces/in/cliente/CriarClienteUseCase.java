package br.com.fiap.fiapeats.usecases.interfaces.in.cliente;

import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.domain.entities.Cliente;

public interface CriarClienteUseCase {
    Cliente criar(CriarClienteDTO criarClienteDTO);
}
