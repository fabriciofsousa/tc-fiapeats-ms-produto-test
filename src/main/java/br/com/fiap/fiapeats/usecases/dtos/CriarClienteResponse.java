package br.com.fiap.fiapeats.usecases.dtos;

public class CriarClienteResponse {

  private final String nome;

  private final String email;

  private final String documento;

  public CriarClienteResponse(String nome, String email, String documento) {
    this.nome = nome;
    this.email = email;
    this.documento = documento;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public String getDocumento() {
    return documento;
  }
}
