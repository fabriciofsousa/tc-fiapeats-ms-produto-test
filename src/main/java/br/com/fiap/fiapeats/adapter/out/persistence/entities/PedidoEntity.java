package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pedido")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

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
}
