package br.com.fiap.fiapeats.adapter.in.controller;

import br.com.fiap.fiapeats.adapter.in.Exception.CategoriaInvalida;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.ProdutoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ProdutoResponse;
import br.com.fiap.fiapeats.adapter.in.utils.ImageUtils;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.ProdutoUseCasePort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.UUID;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    @Autowired
    private ProdutoUseCasePort useCase;

    @PostMapping
    public ResponseEntity<Object> criarProduto(@RequestBody ProdutoRequest produtoRequest){
        logger.info("Requisição para criar produto recebida");

        var produto = useCase.criar(new Produto(produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor(), produtoRequest.getCategoria(), produtoRequest.getImagemUrl()));

        logger.info("Produto criado com sucesso");

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getCategoria(), produto.getValor(), produto.getImagemUrl()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarProduto(@PathVariable UUID id, @RequestBody ProdutoRequest produtoRequest){
        logger.info("Requisição para editar produto recebida");

        var produto = useCase.editar(id, new Produto(produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor(), produtoRequest.getCategoria(), produtoRequest.getImagemUrl()));

        return ResponseEntity.status(HttpStatus.OK).body(new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getCategoria(), produto.getValor(), produto.getImagemUrl()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> removerProduto(@PathVariable UUID id){
        logger.info("Requisição para remover produto recebida");

        useCase.excluir(id);

        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso");
    }


}
