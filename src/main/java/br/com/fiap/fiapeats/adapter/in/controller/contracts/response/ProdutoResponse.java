package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ProdutoResponse {

  private UUID id;

  private String nome;

  private String descricao;

  private String categoria;

  private BigDecimal valor;

  private String imagemUrl;

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
