package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PedidoResponse {
  private String idPedido;
  private String cliCpf;
  private String status;
  private int tempoEspera;
  private LocalDate dataCriacao;
}
