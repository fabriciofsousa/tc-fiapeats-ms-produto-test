package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.ClientePresenter;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteResponse;
import br.com.fiap.fiapeats.usecases.dtos.IdentificarClienteResponse;
import br.com.fiap.fiapeats.usecases.interfaces.in.cliente.CriarClienteUseCase;
import br.com.fiap.fiapeats.usecases.interfaces.in.cliente.IdentificarClienteUseCase;
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
