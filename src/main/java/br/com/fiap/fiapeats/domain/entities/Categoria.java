package br.com.fiap.fiapeats.domain.entities;

public class Categoria {

  private Long id;
  private String descricao;

  public Categoria(Long id, String descricao) {
    this.id = id;
    this.descricao = descricao.substring(0, 1).toUpperCase().concat(descricao.substring(1).toLowerCase());
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
