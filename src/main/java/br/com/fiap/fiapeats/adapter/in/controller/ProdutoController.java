package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.CriarProdutoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.ProdutoMapper;
import br.com.fiap.fiapeats.core.ports.in.CriarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.EditarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.in.ExcluirProdutoUseCasePort;
import br.com.fiap.fiapeats.core.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import javax.validation.Valid;
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
@Tag(name = "Produto")
@RequestMapping("/produto")
public class ProdutoController {

  @Autowired private ProdutoMapper produtoMapper;
  @Autowired private CriarProdutoUseCasePort criarProdutoUseCasePort;
  @Autowired private EditarProdutoUseCasePort editarProdutoUseCasePort;
  @Autowired private ExcluirProdutoUseCasePort excluirProdutoUseCasePort;

  @PostMapping("/criar")
  @Operation(summary = "Cria um novo produto")
  @ApiResponses(
      value = {@ApiResponse(responseCode = "201", description = "Pedido criado com sucesso")})
  public ResponseEntity<CriarProdutoResponse> criarProduto(
      @Valid @RequestBody CriarProdutoRequest produtoRequest) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "Solicitacao recebida [criarProduto] ");

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            produtoMapper.toCriarProdutoResponse(
                criarProdutoUseCasePort.criar(
                    produtoMapper.criarProdutoRequestToProduto(produtoRequest))));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> editarProduto(
      @PathVariable UUID id, @RequestBody EditarProdutoRequest editarProdutoRequest) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "Solicitacao recebida [editarProduto] ");

    return ResponseEntity.status(HttpStatus.OK)
        .body(
            produtoMapper.toEditarProdutoResponse(
                editarProdutoUseCasePort.editar(
                    produtoMapper.editarProdutoRequestToProduto(id, editarProdutoRequest))));
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Object> removerProduto(@PathVariable UUID id) {
    ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
    log.info(
        "correlationId={"
            + ThreadContext.get(Constants.CORRELATION_ID)
            + "} "
            + "Solicitacao recebida [removerProduto] ");

    excluirProdutoUseCasePort.excluir(id);

    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
