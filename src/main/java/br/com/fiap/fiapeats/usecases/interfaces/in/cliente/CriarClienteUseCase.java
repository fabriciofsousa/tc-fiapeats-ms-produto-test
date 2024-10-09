package br.com.fiap.fiapeats.usecases.interfaces.in.cliente;

import br.com.fiap.fiapeats.domain.entities.Cliente;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;

public interface CriarClienteUseCase {
  Cliente criar(CriarClienteDTO criarClienteDTO);
}
