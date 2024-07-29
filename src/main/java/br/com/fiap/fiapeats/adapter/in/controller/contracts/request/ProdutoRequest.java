package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProdutoRequest {

    @Size(min = 1, max = 60, message = "Deve conter no máximo 60 caracteres")
    @Schema(description = "nome do produto", example = "Refrigerante Guaraná")
    private String nome;

    @Schema(description = "descrição do produto", example = "Refrigerante lata 350ml")
    private String descricao;


    @Size(min = 1, max = 10, message = "Deve conter no máximo 10 caracteres")
    @Pattern(regexp = "^[0-9\\.]+$", message = "Aceita apenas números e ponto")
    @Schema(description = "valor do produto", example = "7.99")
    private BigDecimal valor;

    @Schema(description = "categoria do produto", example = "Bebida")
    private String categoria;

    public ProdutoRequest(String nome, String descricao, BigDecimal valor, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public String getNome() { return nome; }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }
}
