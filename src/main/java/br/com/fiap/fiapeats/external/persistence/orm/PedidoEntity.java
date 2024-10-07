package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "Pedido")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PedidoEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "ID_PEDIDO")
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

  @ManyToMany private Set<ProdutoEntity> produtos;
}
