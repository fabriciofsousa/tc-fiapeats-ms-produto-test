package br.com.fiap.fiapeats.adapter.in.controller.contracts.request;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PedidoRequest {
  @NotNull(message = "Não pode ser nula")
  @NotEmpty(message = "não pode estar vazia")
  @ArraySchema(
      arraySchema =
          @Schema(
              description = "Lista de ID's de produtos a serem incluídos no pedido",
              example =
                  "[\"eb3ace3d-21cd-42d7-bde0-ecd599986263\", \"nb57fteo-21cd-42d7-bde0-ecf476832018\"]",
              requiredMode = Schema.RequiredMode.REQUIRED),
      uniqueItems = true)
  @Pattern(
      regexp = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$",
      message = "Deve conter apenas UUID")
  private List<String> idProdutos;

  @Size(min = 11, max = 11, message = "Deve conter exatamente 11 dígitos")
  @NotEmpty(message = "Não pode ser vazio")
  @Pattern(regexp = "^[0-9]*$", message = "Aceita apenas números")
  @Schema(
      description = "numero do documento",
      example = "76590487654",
      requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  private String cliCpf;

  @Positive(message = "Deve ser maior que 0")
  @NotEmpty(message = "Não pode ser vazio")
  @NotNull(message = "Não pode ser nulo")
  @Pattern(regexp = "^[0-9][0-9.]*[0-9]*$", message = "Para centavos, utilizar [.]")
  @Schema(
      description = "Valor do pedido",
      example = "86.15",
      requiredMode = Schema.RequiredMode.REQUIRED)
  private BigDecimal valor;
}
