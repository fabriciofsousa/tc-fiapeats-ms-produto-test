package br.com.fiap.fiapeats.core.domain;

public class Categoria {

  private Long id;
  private String descricao;

  public Categoria(Long id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public static Categoria adicionarDescricao(String descricao) {
    return new Categoria(
        null, descricao.substring(0, 1).toUpperCase().concat(descricao.substring(1).toLowerCase()));
  }

  public Long getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }
}
