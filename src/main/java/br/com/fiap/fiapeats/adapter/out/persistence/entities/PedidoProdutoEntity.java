package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pedido_Produto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoProdutoEntity implements Serializable {

  @EmbeddedId PedidoProdutoID id;
}
