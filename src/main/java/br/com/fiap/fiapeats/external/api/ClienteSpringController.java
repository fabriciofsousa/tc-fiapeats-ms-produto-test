package br.com.fiap.fiapeats.external.api;

import br.com.fiap.fiapeats.adapter.controller.ClienteController;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteDTO;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarClienteRequest;
import br.com.fiap.fiapeats.usecases.dtos.CriarClienteResponse;
import br.com.fiap.fiapeats.usecases.dtos.IdentificarClienteResponse;
import br.com.fiap.fiapeats.external.api.mapper.ClienteMapper;
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
public class ClienteSpringController {

    @Autowired
    private ClienteController clienteController;

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

        CriarClienteDTO criarClienteDTO = clienteMapper.toCriarClienteDTO(criarClienteRequest);

        return ResponseEntity.status(201)
                .body(clienteController.cadastrarClente(criarClienteDTO));
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
        return ResponseEntity.ok(clienteController.identificarCliente(documento));
    }
}
