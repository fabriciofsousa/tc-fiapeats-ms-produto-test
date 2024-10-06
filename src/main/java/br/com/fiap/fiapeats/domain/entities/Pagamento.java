package br.com.fiap.fiapeats.domain.entities;

import java.util.UUID;

public class Pagamento {

  private UUID idPedido;

  private String urlNotificacao;

  private String codigoQR;

  public Pagamento(UUID idPedido, String urlNotificacao, String codigoQR) {
    this.idPedido = idPedido;
    this.urlNotificacao = urlNotificacao;
    this.codigoQR = codigoQR;
  }

  public UUID getIdPedido() {
    return idPedido;
  }

  public String getUrlNotificacao() {
    return urlNotificacao;
  }

  public String getCodigoQR() {
    return codigoQR;
  }
}
