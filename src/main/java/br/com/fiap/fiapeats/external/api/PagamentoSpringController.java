package br.com.fiap.fiapeats.external.api;

import br.com.fiap.fiapeats.adapter.controller.ClienteController;
import br.com.fiap.fiapeats.adapter.controller.PagamentoController;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarClienteRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarPagamentoRequest;
import br.com.fiap.fiapeats.external.api.mapper.ClienteMapper;
import br.com.fiap.fiapeats.external.api.mapper.PagamentoMapper;
import br.com.fiap.fiapeats.usecases.dtos.*;
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
@Tag(name = "Pagamento")
@RequestMapping("/pagamento")
public class PagamentoSpringController {

    @Autowired
    private PagamentoController pagamentoController;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @PostMapping
    @Operation(
            summary = "Cria um QRCode para pagamento de um pedido",
            description = "Recebendo os dados necessários, cria-se um novo QRCode para pagamento")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "QRCode pagamento criado com sucesso")})
    public ResponseEntity<CriarPagamentoResponse> criarCodigoPagamento(
            @RequestBody @Valid CriarPagamentoRequest criarPagamentoRequest) {
        log.info("Requisição para criar QRCode para pagamento recebida");

        CriarPagamentoDTO criarPagamentoDTO = pagamentoMapper.toCriarPagamentoDTO(criarPagamentoRequest);

        return ResponseEntity.status(201)
                .body(pagamentoController.criarPagamento(criarPagamentoDTO));
    }
}
