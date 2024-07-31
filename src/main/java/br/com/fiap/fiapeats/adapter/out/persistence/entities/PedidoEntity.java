package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Pedido")
public class PedidoEntity implements Serializable {

  @Id private UUID id;

  @Column(name = "CLIENTE_DOCUMENTO", nullable = true)
  private String cliCpf;

  @Column(name = "VALOR_TOTAL", nullable = false)
  private BigDecimal valor;

  @Column(name = "ID_STATUS", nullable = false)
  private Long idStatus;

  @Column(name = "DATA_HORA_CRIACAO", nullable = false)
  private LocalDateTime dataHoraCriacao;

  @Column(name = "TEMPO_ESPERA", nullable = false)
  private int tempoEspera;

  public PedidoEntity(
      Long idStatus,
      UUID id,
      String cliCpf,
      BigDecimal valor,
      LocalDateTime dataHoraCriacao,
      int tempoEspera) {
    this.idStatus = idStatus;
    this.id = id;
    this.cliCpf = cliCpf;
    this.valor = valor;
    this.dataHoraCriacao = dataHoraCriacao;
    this.tempoEspera = tempoEspera;
  }

  public PedidoEntity() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
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
