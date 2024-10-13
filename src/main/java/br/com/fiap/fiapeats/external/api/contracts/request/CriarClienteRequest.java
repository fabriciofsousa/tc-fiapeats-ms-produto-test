package br.com.fiap.fiapeats.external.api.contracts.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CriarClienteRequest {

  @NotEmpty(message = "Não pode ser vazio")
  @Schema(description = "Nome do cliente", example = "José Carlos")
  private final String nome;

  @NotEmpty(message = "Não pode ser vazio")
  @Email
  @Schema(description = "Email do cliente", example = "jose.carlos@email.com")
  private final String email;

  @NotEmpty(message = "Não pode ser vazio")
  @Size(min = 11, max = 11, message = "Deve conter exatamente 11 dígitos")
  @Schema(
      description = "Número do documento",
      example = "76590487654",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private final String documento;

  public CriarClienteRequest(String nome, String email, String documento) {
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
