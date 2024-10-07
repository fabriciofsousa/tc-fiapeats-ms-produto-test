package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Entity
@Table(name = "produto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
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

  @ManyToOne private CategoriaEntity categoria;

  @Column(name = "imagem_url")
  private String imagemUrl;
}
