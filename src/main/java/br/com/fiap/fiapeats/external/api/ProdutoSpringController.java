package br.com.fiap.fiapeats.external.api;

import br.com.fiap.fiapeats.adapter.controller.ProdutoController;
import br.com.fiap.fiapeats.external.api.mapper.ProdutoMapper;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;
import br.com.fiap.fiapeats.domain.utils.Constants;
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
@Tag(name = "Produto")
@RequestMapping("/produto")
@CrossOrigin({"http://127.0.0.1:5500", "http://localhost:63342"})
public class ProdutoSpringController {

    @Autowired
    private ProdutoController produtoController;

    @Autowired
    private ProdutoMapper produtoMapper;

    @PostMapping()
    @Operation(
            summary = "Cria um novo produto",
            description = "Recebendo os dados necessários, cria-se um novo produto")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201", description = "Produto criado com sucesso"),
                    @ApiResponse(responseCode = "422", description = "Categoria informada inválida")
            })
    public ResponseEntity<CriarProdutoResponse> criarProduto(
            @RequestBody @Valid CriarProdutoRequest produtoRequest) {
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [criarProduto] ");

        CriarProdutoDTO criarProdutoDTO = produtoMapper.toCriarProdutoDTO(produtoRequest);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoController.criarProduto(criarProdutoDTO));
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Altera os dados cadastrais de um produto",
            description = "Recebendo os dados necessários, busca e altera os dados cadastrais do produto")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produto editado com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado"),
                    @ApiResponse(responseCode = "422", description = "Categoria informada inválida")
            })
    public ResponseEntity<Object> editarProduto(
            @PathVariable UUID id, @RequestBody @Valid EditarProdutoRequest editarProdutoRequest) {
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [editarProduto] ");

        EditarProdutoDTO editarProdutoDTO = produtoMapper.toEditarProdutoDTO(id, editarProdutoRequest);

        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoController.editarProduto(editarProdutoDTO));
    }

    @DeleteMapping("{id}")
    @Operation(
            summary = "Exclui um produto",
            description = "Recebendo o id, busca e exclui o produto")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Produto excluído com sucesso"),
                    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
            })
    public ResponseEntity<Object> removerProduto(@PathVariable UUID id) {
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [removerProduto] ");

        produtoController.removerProduto(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    @Operation(
            summary = "Buscar por todos os produtos",
            description = "Lista todos os produtos da base")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listagem de produtos com sucesso"),
                    @ApiResponse(responseCode = "422", description = "Problema com a requisição"),
                    @ApiResponse(responseCode = "404", description = "Nenhum produto na base")
            })
    public ResponseEntity<List<ProdutoResponse>> listarTodosProdutos() {
        ThreadContext.put(Constants.CORRELATION_ID, UUID.randomUUID().toString());
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [listarTodosProdutos] ");
        return ResponseEntity.ok(produtoController.listarTodosProdutos());
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(
            summary = "Buscar produtos por categoria",
            description = "Lista os produtos que pertencem a uma categoria especificada")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Listagem de produtos com sucesso"),
                    @ApiResponse(responseCode = "422", description = "Problema com a requisição"),
                    @ApiResponse(responseCode = "404", description = "Nenhum produto na base")
            })
    public ResponseEntity<List<ProdutoResponse>> consultarProdutoPorCategoria(
            @PathVariable("categoria") String categoria) {
        log.info(
                "correlationId={"
                        + ThreadContext.get(Constants.CORRELATION_ID)
                        + "} "
                        + "Solicitacao recebida [consultarProdutoPorCategoria] ");

        return ResponseEntity.ok(produtoController.consultarProdutoPorCategoria(categoria));
    }
}
