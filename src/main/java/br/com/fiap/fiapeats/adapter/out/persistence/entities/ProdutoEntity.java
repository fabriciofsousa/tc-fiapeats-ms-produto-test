package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProdutoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "nome", nullable = false)
  private String nome;

  @Column(name = "descricao", nullable = false)
  private String descricao;

  @Column(name = "valor", nullable = false)
  private BigDecimal valor;

  @ManyToOne
  @JoinColumn(name = "categoria_id")
  private CategoriaEntity categoria;

  @Column(name = "imagem_url")
  private String imagemUrl;

}
