package br.com.fiap.fiapeats.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    private byte[] foto;

    public Produto(Long id, String nome, String descricao, BigDecimal valor, String categoria, byte[] foto) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.foto = foto;
    }

    public Produto(String nome, String descricao, BigDecimal valor, String categoria, byte[] foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.foto = foto;
    }

    public Produto() {
    }

    public Long getId() { return id; }

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

    public byte[] getFoto() {
        return foto;
    }
}
