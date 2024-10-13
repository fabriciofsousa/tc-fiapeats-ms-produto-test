package br.com.fiap.fiapeats.domain.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class Produto {

  private UUID id;
  private String nome;
  private String descricao;
  private BigDecimal valor;
  private Categoria categoria;
  private String imagemUrl;

  public Produto(UUID id) {
    this.id = id;
  }

  public Produto(
      UUID id,
      String nome,
      String descricao,
      BigDecimal valor,
      Categoria categoria,
      String imagemUrl) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    this.categoria = categoria;
    this.imagemUrl = imagemUrl;
  }

  public Produto(
      String nome, String descricao, BigDecimal valor, Categoria categoria, String imagemUrl) {
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    this.categoria = categoria;
    this.imagemUrl = imagemUrl;
  }

  public Produto adicionarCategoria(Produto produto, Categoria categoria) {
    return new Produto(
        produto.getId(),
        produto.getNome(),
        produto.getDescricao(),
        produto.getValor(),
        new Categoria(categoria.getId(), categoria.getDescricao()),
        produto.getImagemUrl());
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

  public BigDecimal getValor() {
    return valor;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public String getImagemUrl() {
    return imagemUrl;
  }
}
