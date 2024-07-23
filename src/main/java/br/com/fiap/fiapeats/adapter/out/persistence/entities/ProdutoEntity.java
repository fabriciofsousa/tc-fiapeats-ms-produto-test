package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "produto")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String descricao;

    private byte[] foto;

    private String categoria;

    private BigDecimal valor;

    public ProdutoEntity(String nome, String descricao, BigDecimal valor, String categoria, byte[] foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.foto = foto;
    }

    public ProdutoEntity(){
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

    public byte[] getFoto() {
        return foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
