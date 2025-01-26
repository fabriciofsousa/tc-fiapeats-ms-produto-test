package br.com.fiap.fiapeats.domain.entities;

import java.math.BigDecimal;
import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Produto produto = (Produto) o;
    return Objects.equals(id, produto.id) &&
            Objects.equals(nome, produto.nome) &&
            Objects.equals(descricao, produto.descricao) &&
            Objects.equals(valor, produto.valor) &&
            Objects.equals(categoria, produto.categoria) &&
            Objects.equals(imagemUrl, produto.imagemUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, descricao, valor, categoria, imagemUrl);
  }
}
