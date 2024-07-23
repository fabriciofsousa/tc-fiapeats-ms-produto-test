package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoResponse {

    private Long id;

    private String nome;

    private String descricao;

    private String categoria;

    private BigDecimal valor;

    private byte[] foto;

    public ProdutoResponse(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public ProdutoResponse(String nome, String descricao, String categoria, BigDecimal valor, byte[] foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.valor = valor;
        this.foto = foto;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() { return categoria; }

    public BigDecimal getValor() { return valor; }

    public byte[] getFoto() { return foto; }
}
