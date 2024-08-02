package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CriarClienteRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CriarClienteResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.IdentificarClienteResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.ClienteMapper;
import br.com.fiap.fiapeats.core.domain.Cliente;
import br.com.fiap.fiapeats.core.ports.in.CriarClienteUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.IdentificarClienteUseCasePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@Tag(name = "Clientes")
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private CriarClienteUseCasePort criarClienteUseCasePort;

    @Autowired
    private IdentificarClienteUseCasePort identificarClienteUseCasePort;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping
    @Operation(
            summary = "Cadastra um novo cliente",
            description = "Recebendo os dados necessários, cria-se um novo cliente")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Cliente cadastrado com sucesso")})
    public ResponseEntity<CriarClienteResponse> cadastrarCliente(
            @RequestBody CriarClienteRequest criarClienteRequest) {
        log.info("Requisição para criar cliente recebida");

        Cliente cliente = clienteMapper.toCliente(criarClienteRequest);

        return ResponseEntity.status(201).body(clienteMapper.toCriarClienteResponse(criarClienteUseCasePort.criar(cliente)));
    }

    @GetMapping("/{documento}")
    @Operation(
            summary = "Identifica um cliente por documento",
            description = "Recebendo o documento, busca e identifica-se o cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cliente identificado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Cliente cadastrado com sucesso")
            })
    public ResponseEntity<IdentificarClienteResponse> identificarCliente(@PathVariable String documento) {
        log.info("Requisição para identificar um cliente recebida");
        return ResponseEntity.ok(clienteMapper.toIdentificarClienteResponse(identificarClienteUseCasePort.identificar(documento)));
    }

}
