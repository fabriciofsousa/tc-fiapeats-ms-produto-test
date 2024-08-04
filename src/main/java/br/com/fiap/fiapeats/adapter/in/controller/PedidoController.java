package br.com.fiap.fiapeats.adapter.in.controller;

import static br.com.fiap.fiapeats.core.utils.Constants.CORRELATION_ID;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.core.exceptions.ValidaCamposException;
import br.com.fiap.fiapeats.core.ports.in.pedido.CriarPedidoUseCasePort;
import br.com.fiap.fiapeats.core.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Set;
import java.util.UUID;
import javax.validation.*;
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

  @Autowired private PedidoMapper pedidoMapper;
  @Autowired private CriarPedidoUseCasePort criarPedidoUseCasePort;

  @PostMapping("/criar")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Cria um novo pedido",
      description = "Recebendo a lista de produtos e valor, cria um novo pedido")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "200", description = "Pedido Criado com sucesso")})
  public ResponseEntity<PedidoResponse> criarNovoPedido(
      @Valid @RequestBody PedidoRequest pedidoRequest) throws ValidaCamposException {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "Solicitacao recebida [criarNovoPedido] ");
    log.debug(pedidoRequest.toString());
    validarPedidoRequest(pedidoRequest);
    return ResponseEntity.ok(
        pedidoMapper.toPedidoResponse(
            criarPedidoUseCasePort.criarPedido(pedidoMapper.toPedidoFromRequest(pedidoRequest))));
  }

  public void validarPedidoRequest(PedidoRequest pedidoRequest) throws ValidaCamposException {
    ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    Validator validator = validatorFactory.getValidator();
    Set<ConstraintViolation<PedidoRequest>> violacoes = validator.validate(pedidoRequest);
    if (violacoes.isEmpty()) return;
    ValidaCamposException exception = new ValidaCamposException();
    exception.setViolations(violacoes);
    log.error(
        "correlationId={"
            + ThreadContext.get(CORRELATION_ID)
            + "} "
            + exception.getViolacoes().toString());
    throw exception;
  }
}
