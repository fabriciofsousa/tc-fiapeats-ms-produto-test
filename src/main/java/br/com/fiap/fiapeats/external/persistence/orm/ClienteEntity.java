package br.com.fiap.fiapeats.external.persistence.orm;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "cliente")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClienteEntity {

  @Id private String documento;

  private String nome;

  private String email;
}
