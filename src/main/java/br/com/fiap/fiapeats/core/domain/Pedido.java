package br.com.fiap.fiapeats.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Pedido {

  private UUID id;
  private List<String> idProdutos;
  private String cliCpf;
  private BigDecimal valor;
  private Long idStatus;
  private LocalDateTime dataHoraCriacao;
  private int tempoEspera;

  public Pedido(
      UUID id,
      List<String> idProdutos,
      String cliCpf,
      BigDecimal valor,
      Long idStatus,
      LocalDateTime dataHoraCriacao,
      int tempoEspera) {
    this.id = id;
    this.idProdutos = idProdutos;
    this.cliCpf = cliCpf;
    this.valor = valor;
    this.idStatus = idStatus;
    this.dataHoraCriacao = dataHoraCriacao;
    this.tempoEspera = tempoEspera;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public List<String> getIdProdutos() {
    return idProdutos;
  }

  public void setIdProdutos(List<String> idProdutos) {
    this.idProdutos = idProdutos;
  }

  public String getCliCpf() {
    return cliCpf;
  }

  public void setCliCpf(String cliCpf) {
    this.cliCpf = cliCpf;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public Long getIdStatus() {
    return idStatus;
  }

  public void setIdStatus(Long idStatus) {
    this.idStatus = idStatus;
  }

  public LocalDateTime getDataHoraCriacao() {
    return dataHoraCriacao;
  }

  public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
    this.dataHoraCriacao = dataHoraCriacao;
  }

  public int getTempoEspera() {
    return tempoEspera;
  }

  public void setTempoEspera(int tempoEspera) {
    this.tempoEspera = tempoEspera;
  }
}
