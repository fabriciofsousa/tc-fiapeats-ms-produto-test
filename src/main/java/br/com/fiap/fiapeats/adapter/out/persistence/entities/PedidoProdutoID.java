package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoProdutoID implements Serializable {
  private String idPedido;
  private String idProduto;
}
