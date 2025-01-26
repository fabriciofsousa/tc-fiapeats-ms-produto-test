package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

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
