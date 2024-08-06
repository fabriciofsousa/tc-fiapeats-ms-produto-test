package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class ProdutoRequest {

  @NotEmpty(message = "Não pode ser vazio")
  @NotNull(message = "Não pode ser nulo")
  @Size(min = 1, max = 60, message = "Deve conter no máximo 60 caracteres")
  @Schema(description = "nome do produto", example = "Refrigerante Guaraná")
  private String nome;

  @NotEmpty(message = "Não pode ser vazio")
  @NotNull(message = "Não pode ser nulo")
  @Schema(description = "descrição do produto", example = "Refrigerante lata 350ml")
  private String descricao;

  @NotNull(message = "Não pode ser nulo")
  @Size(min = 1, max = 10, message = "Deve conter no máximo 10 caracteres")
  @Pattern(regexp = "^[0-9][0-9.]+$", message = "Aceita apenas números e ponto")
  @Positive(message = "O valor precisa ser maior que 0")
  @Schema(description = "valor do produto", example = "7.99")
  private BigDecimal valor;

  @NotEmpty(message = "Não pode ser vazio")
  @NotNull(message = "Não pode ser nulo")
  @Schema(description = "categoria do produto", example = "Bebida")
  private String categoria;

  @Schema(
      description = "url da imagem do produto",
      example =
          "https://static.itdg.com.br/images/1200-630/150ba2d5d2874bed8561dd8edbdc1323/164773-original.jpg")
  private String imagemUrl;

  public ProdutoRequest(
      String nome, String descricao, BigDecimal valor, String categoria, String imagemUrl) {
    this.nome = nome;
    this.descricao = descricao;
    this.valor = valor;
    this.categoria = categoria;
    this.imagemUrl = imagemUrl;
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

  public String getCategoria() {
    return categoria;
  }

  public String getImagemUrl() {
    return imagemUrl;
  }
}
