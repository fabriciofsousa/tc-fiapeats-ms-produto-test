package br.com.fiap.fiapeats.external.api.contracts.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class CriarPagamentoRequest {

  @NotNull(message = "Não pode ser null")
  @Schema(description = "Id do pedido", example = "e1ba3631-70c9-447d-ac48-256792bf8e7u")
  private final UUID idPedido;

  @NotEmpty(message = "Não pode ser vazio")
  @Schema(description = "Url que receberá a notificação de status do pagamento", example = "https://notifica-me.com.br")
  private final String urlNotificacao;

  public CriarPagamentoRequest(UUID idProduto, String urlNotificacao) {
    this.idPedido = idProduto;
    this.urlNotificacao = urlNotificacao;
  }

  public UUID getIdPedido() {
    return idPedido;
  }

  public String getUrlNotificacao() {
    return urlNotificacao;
  }
}
