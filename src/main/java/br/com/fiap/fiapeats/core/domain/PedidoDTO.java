package br.com.fiap.fiapeats.core.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class PedidoDTO {

  private UUID id;
  private List<String> idProdutos;
  private String cliCpf;
  private BigDecimal valor;
  private Long idStatus;
  private LocalDate dataCriacao;
  private int tempoEspera;

  public PedidoDTO(
      UUID id,
      List<String> idProdutos,
      String cliCpf,
      BigDecimal valor,
      Long idStatus,
      LocalDate dataCriacao,
      int tempoEspera) {
    this.id = id;
    this.idProdutos = idProdutos;
    this.cliCpf = cliCpf;
    this.valor = valor;
    this.idStatus = idStatus;
    this.dataCriacao = dataCriacao;
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

  public LocalDate getDataCriacao() {
    return dataCriacao;
  }

  public void setDataCriacao(LocalDate dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  public int getTempoEspera() {
    return tempoEspera;
  }

  public void setTempoEspera(int tempoEspera) {
    this.tempoEspera = tempoEspera;
  }
}
