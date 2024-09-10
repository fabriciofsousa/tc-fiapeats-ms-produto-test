package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.controller.contracts.request.CriarClienteRequest;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.CriarClienteResponse;
import br.com.fiap.fiapeats.adapter.controller.contracts.response.IdentificarClienteResponse;
import br.com.fiap.fiapeats.adapter.controller.mapper.ClienteMapper;
import br.com.fiap.fiapeats.entities.Cliente;
import br.com.fiap.fiapeats.interfaces.in.cliente.CriarClienteUseCaseInterface;
import br.com.fiap.fiapeats.interfaces.in.cliente.IdentificarClienteUseCaseInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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
    private CriarClienteUseCaseInterface criarClienteUseCaseInterface;

    @Autowired
    private IdentificarClienteUseCaseInterface identificarClienteUseCaseInterface;

    @Autowired
    private ClienteMapper clienteMapper;

    @PostMapping
    @Operation(
            summary = "Cadastra um novo cliente",
            description = "Recebendo os dados necessários, cria-se um novo cliente")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso")})
    public ResponseEntity<CriarClienteResponse> cadastrarCliente(
            @RequestBody @Valid CriarClienteRequest criarClienteRequest) {
        log.info("Requisição para criar cliente recebida");

        Cliente cliente = clienteMapper.toCliente(criarClienteRequest);

        return ResponseEntity.status(201)
                .body(clienteMapper.toCriarClienteResponse(criarClienteUseCaseInterface.criar(cliente)));
    }

    @GetMapping("/{documento}")
    @Operation(
            summary = "Identifica um cliente por documento",
            description = "Recebendo o documento, busca e identifica-se o cliente")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Cliente identificado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Cliente não identificado")
            })
    public ResponseEntity<IdentificarClienteResponse> identificarCliente(
            @PathVariable String documento) {
        log.info("Requisição para identificar um cliente recebida");
        return ResponseEntity.ok(
                clienteMapper.toIdentificarClienteResponse(
                        identificarClienteUseCaseInterface.identificar(documento)));
    }
}
