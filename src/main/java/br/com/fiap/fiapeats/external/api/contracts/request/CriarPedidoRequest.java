package br.com.fiap.fiapeats.external.api.contracts.request;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CriarPedidoRequest {
  @Size(min = 1, message = "a lista deve conter pelo menos 1 produto")
  @ArraySchema(
      arraySchema =
          @Schema(
              description = "Lista de ID's de produtos a serem incluídos no pedido",
              example =
                  "[\"fc7c7f37-32ea-465c-ac4b-490685e5a55f\", \"fa0f9dde-b305-407b-869c-71045853dea8\"]",
              requiredMode = Schema.RequiredMode.REQUIRED),
      uniqueItems = true)
  private List<UUID> idProdutos;

  @Size(min = 11, max = 11, message = "Deve conter exatamente 11 dígitos")
  @Pattern(regexp = "^[0-9]*$", message = "Aceita apenas números")
  @Schema(
      description = "numero do documento",
      example = "76590487654",
      requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  private String cliCpf;

  @Positive(message = "Deve ser maior que 0")
  @NotNull(message = "Não pode ser nulo")
  @Schema(
      description = "Valor do pedido",
      example = "86.15",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private BigDecimal valor;
}
