package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "Pedido_Produto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PedidoProdutoEntity implements Serializable {

  @EmbeddedId private PedidoProdutoId id;

  @ManyToOne
  @MapsId("idPedido")
  @JoinColumn(name = "ID_PEDIDO")
  private PedidoEntity pedido;

  @Embeddable
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  @Getter
  @Setter
  public static class PedidoProdutoId implements Serializable {
    @Column(name = "ID_PEDIDO")
    private UUID idPedido;

    @Column(name = "ID_PRODUTO")
    private UUID idProduto;
  }
}
