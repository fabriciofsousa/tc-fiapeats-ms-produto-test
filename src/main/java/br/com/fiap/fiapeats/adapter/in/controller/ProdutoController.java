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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> criarProduto(@RequestParam(required = true) String nome,
                                                   @RequestParam(required = true) String descricao,
                                                   @RequestParam(required = true) BigDecimal valor,
                                                   @RequestParam(required = true) String categoria,
                                                   @RequestParam(required = false) MultipartFile foto){
        logger.info("Requisição para criar produto recebida");

        ProdutoResponse produto;

        try {
           produto = useCase.criar(new Produto(nome, descricao, valor, categoria, ImageUtils.convertImageToBase64(foto)));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        logger.info("Produto criado com sucesso");

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarProduto(@PathVariable UUID id, @RequestBody ProdutoRequest produtoRequest){
        logger.info("Requisição para editar produto recebida");

        useCase.editar(id, new Produto(produtoRequest.getNome(), produtoRequest.getDescricao(), produtoRequest.getValor(), produtoRequest.getCategoria()));

        return ResponseEntity.status(HttpStatus.OK).body("Produto editado com sucesso");
    }

    public ResponseEntity<Object> removerProduto(){


        return ResponseEntity.status(HttpStatus.OK).body("Produto removido com sucesso");
    }


}
