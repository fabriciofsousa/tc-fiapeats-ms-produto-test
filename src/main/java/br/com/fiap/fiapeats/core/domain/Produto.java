package br.com.fiap.fiapeats.core.domain;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.ProdutoRequest;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private UUID id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    private String imagemUrl;

    public Produto() {
    }

    public Produto(UUID id) {
        this.id = id;
    }

    public Produto(UUID id, String nome, String descricao, BigDecimal valor, String categoria, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    public Produto(String nome, String descricao, BigDecimal valor, String categoria, String imagemUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }

    public Produto(String nome, String descricao, BigDecimal valor, String categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
    }

    public UUID getId() { return id; }

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

    public String getImagemUrl() { return imagemUrl; }
}
