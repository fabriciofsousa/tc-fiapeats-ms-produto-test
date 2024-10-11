package br.com.fiap.fiapeats.usecases.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListarPedidosResponse {
  private String id;
  private String cliCpf;
  private String status;
  private BigDecimal valor;
  private int tempoEspera;
  private LocalDateTime dataHoraCriacao;
  private String statusPagamento;
  private List<ProdutoResponse> produtos;

  public ListarPedidosResponse(
      String id,
      String cliCpf,
      String status,
      BigDecimal valor,
      int tempoEspera,
      LocalDateTime dataHoraCriacao,
      String statusPagamento,
      List<ProdutoResponse> produtos) {
    this.id = id;
    this.cliCpf = cliCpf;
    this.status = status;
    this.valor = valor;
    this.tempoEspera = tempoEspera;
    this.dataHoraCriacao = dataHoraCriacao;
    this.statusPagamento = statusPagamento;
    this.produtos = produtos;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCliCpf() {
    return cliCpf;
  }

  public void setCliCpf(String cliCpf) {
    this.cliCpf = cliCpf;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
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

  public String getStatusPagamento() { return statusPagamento; }

  public void setStatusPagamento(String statusPagamento) { this.statusPagamento = statusPagamento; }

  public List<ProdutoResponse> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<ProdutoResponse> produtos) {
    this.produtos = produtos;
  }
}
