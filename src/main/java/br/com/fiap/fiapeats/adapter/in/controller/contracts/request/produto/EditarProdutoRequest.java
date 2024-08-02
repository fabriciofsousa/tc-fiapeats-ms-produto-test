package br.com.fiap.fiapeats.adapter.in.controller.contracts.request.produto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EditarProdutoRequest {

    @NotEmpty(message = "Não pode ser vazio")
    @NotNull(message = "Não pode ser nulo")
    @Size(min = 1, max = 60, message = "Deve conter no máximo 60 caracteres")
    @Schema(
            description = "nome do produto",
            example = "Refrigerante Guaraná",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String nome;

    @NotEmpty(message = "Não pode ser vazio")
    @NotNull(message = "Não pode ser nulo")
    @Schema(description = "descrição do produto",
            example = "Refrigerante lata 350ml",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String descricao;

    @Positive(message = "Deve ser maior que 0")
    @NotNull(message = "Não pode ser nulo")
    @Size(min = 1, max = 10, message = "Deve conter no máximo 10 caracteres")
    @Pattern(regexp = "^[0-9][0-9.]+$", message = "Aceita apenas números e ponto")
    @Positive(message = "O valor precisa ser maior que 0")
    @Schema(
            description = "valor do produto",
            example = "7.99",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private BigDecimal valor;

    @NotEmpty(message = "Não pode ser vazio")
    @NotNull(message = "Não pode ser nulo")
    @Schema(
            description = "categoria do produto",
            example = "Bebida",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String categoria;

    @Schema(
            description = "url da imagem do produto",
            example = "https://static.itdg.com.br/images/1200-630/150ba2d5d2874bed8561dd8edbdc1323/164773-original.jpg",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String imagemUrl;
}
