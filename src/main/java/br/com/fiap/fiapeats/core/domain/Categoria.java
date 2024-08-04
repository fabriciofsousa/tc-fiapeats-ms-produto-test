package br.com.fiap.fiapeats.core.domain;

public class Categoria {

  private Long id;
  private String descricao;

  public Categoria(Long id, String descricao) {
    this.id = id;
    this.descricao = descricao;
  }

  public static Categoria adicionarDescricao(String descricao) {
    return new Categoria(null, descricao);
  }

  public Long getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }

  public enum Enum {
    LANCHE(1L, "LANCHE"),
    ACOMPANHAMENTO(2L, "ACOMPANHAMENTO"),
    BEBIDA(3L, "BEBIDA"),
    SOBREMESA(4L, "SOBREMESA");

    private Long id;
    private String descricao;

    private Enum(Long id, String descricao) {
      this.id = id;
      this.descricao = descricao;
    }

    public String getDescricao() {
      return descricao;
    }

    public Long getId() {
      return id;
    }
  }
}
