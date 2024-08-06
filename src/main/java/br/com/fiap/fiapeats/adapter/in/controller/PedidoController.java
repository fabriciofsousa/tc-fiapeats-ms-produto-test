package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CriarPedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ListarPedidosResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.core.ports.in.pedido.CriarPedidoUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.pedido.ListarPedidosUseCasePort;
import br.com.fiap.fiapeats.core.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Pedidos")
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoMapper pedidoMapper;

    @Autowired
    private CriarPedidoUseCasePort criarPedidoUseCasePort;

    @Autowired
    private ListarPedidosUseCasePort listarPedidosUseCasePort;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Cria um novo pedido",
            description = "Recebendo a lista de produtos e valor, cria um novo pedido")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Pedido Criado com sucesso")})
    public ResponseEntity<CriarPedidoResponse> criarNovoPedido(
            @Valid @RequestBody PedidoRequest pedidoRequest) {
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [criarNovoPedido] ");
        log.debug(pedidoRequest.toString());
        return ResponseEntity.ok(
                pedidoMapper.toPedidoResponse(
                        criarPedidoUseCasePort.criarPedido(pedidoMapper.toPedidoFromRequest(pedidoRequest))));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Lista os pedidos",
            description = "Rota para listar todos os pedidos cadastrados")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso!")})
    public ResponseEntity<List<ListarPedidosResponse>> listarPedidos() {
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [criarNovoPedido] ");
        return ResponseEntity.ok(
                pedidoMapper.toListarPedidosResponse(listarPedidosUseCasePort.listar()));
    }
}
