package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import java.math.BigDecimal;

public class ProdutoRequest {

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    //@Schema(description = "foto do produto")
    private String foto;

    public ProdutoRequest(String nome, String descricao, BigDecimal valor, String categoria, String foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.foto = foto;
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

    public String getFoto() {
        return foto;
    }

}
