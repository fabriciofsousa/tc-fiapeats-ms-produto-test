package br.com.fiap.fiapeats.external.api.contracts.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class AlterarStatusPedidoRequest {

    @NotNull(message = "Status não pode ser nulo")
    @Schema(
            description = "Novo status do pedido",
            example = "1",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private Long status;

    public AlterarStatusPedidoRequest() {
    }

    public AlterarStatusPedidoRequest(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }
}
