package br.com.fiap.fiapeats.external.api;

import br.com.fiap.fiapeats.adapter.controller.PedidoController;
import br.com.fiap.fiapeats.domain.utils.Constants;
import br.com.fiap.fiapeats.external.api.contracts.request.AlterarStatusPedidoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarPedidoRequest;
import br.com.fiap.fiapeats.external.api.mapper.PedidoMapper;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoDTO;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ListarPedidosResponse;
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
public class PedidoSpringController {

  @Autowired
  private PedidoMapper pedidoMapper;

  @Autowired
  private PedidoController pedidoController;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  @Operation(
          summary = "Cria um novo pedido",
          description = "Recebendo a lista de produtos e valor, cria um novo pedido")
  @ApiResponses(
          value = {@ApiResponse(responseCode = "200", description = "Pedido Criado com sucesso")})
  public ResponseEntity<CriarPedidoResponse> criarNovoPedido(
          @Valid @RequestBody CriarPedidoRequest criarPedidoRequest) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "Solicitacao recebida [criarNovoPedido] ");
    log.debug(criarPedidoRequest.toString());

    CriarPedidoDTO criarPedidoDTO = pedidoMapper.toCriarPedidoDTO(criarPedidoRequest);

    return ResponseEntity.ok(pedidoController.criarNovoPedido(criarPedidoDTO));
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
    return ResponseEntity.ok(pedidoController.listarPedidos());
  }

  @GetMapping("{idStatusPagamento}/pagamento")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
          summary = "Lista os pedidos filtrados por id status pagamento",
          description = "Rota para listar todos os pedidos cadastrados filtrados por id status pagamento")
  @ApiResponses(
          value = {@ApiResponse(responseCode = "200", description = "Pedidos listados com sucesso!")})
  public ResponseEntity<List<ListarPedidosResponse>> listarPedidosPorIdStatusPagamento(@PathVariable Long idStatusPagamento) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "Solicitacao recebida [ListarPedidosPorIdStatusPagamento] ");
    return ResponseEntity.ok(pedidoController.listarPedidosPorIdStatusPagamento(idStatusPagamento));
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
          summary = "Buscar um pedido por id",
          description = "Rota para listar pedido cadastrado filtrado por id")
  @ApiResponses(
          value = {@ApiResponse(responseCode = "200", description = "Pedido encontrado com sucesso!")})
  public ResponseEntity<ListarPedidosResponse> listarPedidoPorId(@PathVariable UUID id) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
            "correlationId={"
                    + ThreadContext.get(Constants.CORRELATION_ID)
                    + "} "
                    + "Solicitacao recebida [ListarPedidoPorId] ");
    return ResponseEntity.ok(pedidoController.listarPedidosPorId(id));
  }

  @PatchMapping("/{id}/status")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
          summary = "Atualiza status do pedido por id",
          description = "Rota para atualizar status do pedido por id")
  @ApiResponses(
          value = {@ApiResponse(responseCode = "200", description = "Status do pedido atualizado com sucesso!")})
  public ResponseEntity<ListarPedidosResponse> alterarStatusPedido(@PathVariable UUID id,
                                                                   @RequestBody AlterarStatusPedidoRequest alterarStatusPedidoRequestDTO) {
    return ResponseEntity.ok(pedidoController.alterarStatusPedido(id, alterarStatusPedidoRequestDTO));
  }
}
