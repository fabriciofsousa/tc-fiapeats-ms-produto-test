package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoriaEntity {

  @Id private Long id;

  @Column(name = "descricao")
  private String descricao;
}
