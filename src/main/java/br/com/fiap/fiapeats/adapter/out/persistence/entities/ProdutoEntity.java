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
    private UUID id;

    private String nome;

    private String descricao;

    private BigDecimal valor;

    private String categoria;

    private String imagemUrl;

    public ProdutoEntity(){
    }

    public ProdutoEntity(UUID id, String nome, String descricao, BigDecimal valor, String categoria, String imagemUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.imagemUrl = imagemUrl;
    }


    public ProdutoEntity(String nome, String descricao, BigDecimal valor, String categoria, String imagemUrl) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
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

    public String getImagemUrl() { return imagemUrl; }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
