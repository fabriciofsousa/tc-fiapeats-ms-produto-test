package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ListarPedidosResponse {
  private String id;
  private String cliCpf;
  private Long idStatus;
  private BigDecimal valor;
  private int tempoEspera;
  private LocalDateTime dataHoraCriacao;
  private List<ProdutoResponse> produtos;
}
