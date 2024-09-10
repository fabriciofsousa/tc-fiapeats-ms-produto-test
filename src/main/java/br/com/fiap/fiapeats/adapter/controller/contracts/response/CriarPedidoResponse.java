package br.com.fiap.fiapeats.adapter.controller.contracts.response;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CriarPedidoResponse {
  private String idPedido;
  private String cliCpf;
  private Long status;
  private int tempoEspera;
  private LocalDateTime dataHoraCriacao;
}
