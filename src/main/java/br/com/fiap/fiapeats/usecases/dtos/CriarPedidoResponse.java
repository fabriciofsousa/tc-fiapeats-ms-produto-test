package br.com.fiap.fiapeats.usecases.dtos;

import java.time.LocalDateTime;

public class CriarPedidoResponse {
  private String idPedido;
  private String cliCpf;
  private Long status;
  private int tempoEspera;
  private LocalDateTime dataHoraCriacao;

  public CriarPedidoResponse(String idPedido, String cliCpf, Long status, int tempoEspera, LocalDateTime dataHoraCriacao) {
    this.idPedido = idPedido;
    this.cliCpf = cliCpf;
    this.status = status;
    this.tempoEspera = tempoEspera;
    this.dataHoraCriacao = dataHoraCriacao;
  }

  public String getIdPedido() {
    return idPedido;
  }

  public void setIdPedido(String idPedido) {
    this.idPedido = idPedido;
  }

  public String getCliCpf() {
    return cliCpf;
  }

  public void setCliCpf(String cliCpf) {
    this.cliCpf = cliCpf;
  }

  public Long getStatus() {
    return status;
  }

  public void setStatus(Long status) {
    this.status = status;
  }

  public int getTempoEspera() {
    return tempoEspera;
  }

  public void setTempoEspera(int tempoEspera) {
    this.tempoEspera = tempoEspera;
  }

  public LocalDateTime getDataHoraCriacao() {
    return dataHoraCriacao;
  }

  public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
    this.dataHoraCriacao = dataHoraCriacao;
  }
}
