package br.com.fiap.fiapeats.usecases.dtos;

import br.com.fiap.fiapeats.domain.entities.Produto;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoResponse {

    private UUID id;

    private String nome;

    private String descricao;

    private String categoria;

    private BigDecimal valor;

    private String imagemUrl;

    public ProdutoResponse() {
    }

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.categoria = produto.getCategoria().getDescricao();
        this.valor = produto.getValor();
        this.imagemUrl = produto.getImagemUrl();
    }

    public ProdutoResponse(UUID id) {
        this.id = id;
    }

    public ProdutoResponse(
            UUID id,
            String nome,
            String descricao,
            String categoria,
            BigDecimal valor,
            String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.imagemUrl = imagemUrl;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
