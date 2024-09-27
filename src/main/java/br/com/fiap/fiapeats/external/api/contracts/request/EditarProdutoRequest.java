package br.com.fiap.fiapeats.external.api.contracts.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EditarProdutoRequest {

  @NotEmpty(message = "Não pode ser vazio")
  @Size(min = 1, max = 60, message = "Deve conter no máximo 60 caracteres")
  @Schema(
      description = "nome do produto",
      example = "Refrigerante Guaraná",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private String nome;

  @NotEmpty(message = "Não pode ser vazio")
  @Schema(
      description = "descrição do produto",
      example = "Refrigerante lata 350ml",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private String descricao;

  @Positive(message = "Deve ser maior que 0")
  @NotNull(message = "Não pode ser nulo")
  @Positive(message = "O valor precisa ser maior que 0")
  @Schema(
      description = "valor do produto",
      example = "7.99",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private BigDecimal valor;

  @NotEmpty(message = "Não pode ser vazio")
  @Schema(
      description = "categoria do produto",
      example = "Bebida",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private String categoria;

  @Size(max = 250, message = "Deve conter no máximo 250 caracteres")
  @Schema(
      description = "url da imagem do produto",
      example =
          "https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png",
      requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  private String imagemUrl;
}
