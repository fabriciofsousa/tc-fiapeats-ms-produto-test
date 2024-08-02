package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.produto.CriarProdutoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.produto.CriarProdutoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.ProdutoMapper;
import br.com.fiap.fiapeats.core.ports.in.CriarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.utils.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Produto")
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired private ProdutoMapper produtoMapper;
    @Autowired private CriarProdutoUseCasePort criarProdutoUseCasePort;

    @PostMapping("/criar")
    @Operation(
            summary = "Cria um novo produto")
    @ApiResponses(
            value = {@ApiResponse(responseCode = "201", description = "Pedido criado com sucesso")})
    public ResponseEntity<CriarProdutoResponse> criarProduto(@Valid @RequestBody CriarProdutoRequest produtoRequest){
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [criarProduto] ");

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoMapper.domainToResponse(
                        criarProdutoUseCasePort.criar(produtoMapper.requestToDomain(produtoRequest))));

     }

//    @PutMapping("/{id}")
//    public ResponseEntity<Object> editarProduto(@PathVariable UUID id, @RequestBody ProdutoRequest produtoRequest){
//        logger.info("Requisição para editar produto recebida");
//
//        var produto = useCase.editar(id, new Produto(produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor(), new Categoria(produtoRequest.getCategoria()), produtoRequest.getImagemUrl()));
//
//        return ResponseEntity.status(HttpStatus.OK).body(new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produtoRequest.getCategoria(), produto.getValor(), produto.getImagemUrl()));
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<Object> removerProduto(@PathVariable UUID id){
//        logger.info("Requisição para remover produto recebida");
//
//        useCase.excluir(id);
//
//        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso");
//    }


}
