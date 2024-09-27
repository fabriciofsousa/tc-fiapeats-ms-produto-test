package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.ClientePresenter;
import br.com.fiap.fiapeats.domain.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.domain.dtos.CriarClienteResponse;
import br.com.fiap.fiapeats.domain.dtos.IdentificarClienteResponse;
import br.com.fiap.fiapeats.domain.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.domain.interfaces.in.cliente.IdentificarClienteUseCase;
import br.com.fiap.fiapeats.domain.entities.Cliente;

public class ClienteController {

    private final CriarClienteUseCase criarClienteUseCase;

    private final IdentificarClienteUseCase identificarClienteUseCase;

    public ClienteController(CriarClienteUseCase criarClienteUseCase,
                             IdentificarClienteUseCase identificarClienteUseCase) {
        this.criarClienteUseCase = criarClienteUseCase;
        this.identificarClienteUseCase = identificarClienteUseCase;
    }

    public CriarClienteResponse cadastrarClente(CriarClienteDTO criarClienteDTO) {
        Cliente cliente = criarClienteUseCase.criar(criarClienteDTO);

        return ClientePresenter.toCriarClienteResponse(cliente);
    }

    public IdentificarClienteResponse identificarCliente(String documento) {
        Cliente cliente = identificarClienteUseCase.identificar(documento);

        return ClientePresenter.toIdentificarClienteResponse(cliente);
    }
}
