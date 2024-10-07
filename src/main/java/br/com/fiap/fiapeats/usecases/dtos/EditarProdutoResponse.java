package br.com.fiap.fiapeats.usecases.dtos;

import java.math.BigDecimal;
import java.util.UUID;

public class EditarProdutoResponse {

  private UUID id;

  private String nome;

  private String descricao;

  private BigDecimal valor;

  private String categoria;

  private String imagemUrl;

  public EditarProdutoResponse(UUID id, String nome, String descricao, BigDecimal valor, String categoria, String imagemUrl) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    this.categoria = categoria;
    this.imagemUrl = imagemUrl;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public String getImagemUrl() {
    return imagemUrl;
  }

  public void setImagemUrl(String imagemUrl) {
    this.imagemUrl = imagemUrl;
  }
}
