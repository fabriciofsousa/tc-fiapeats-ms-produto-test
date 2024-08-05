package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class ClienteEntity {

  @Id private String documento;

  private String nome;

  private String email;

  public ClienteEntity(String documento, String nome, String email) {
    this.documento = documento;
    this.nome = nome;
    this.email = email;
  }

  public ClienteEntity() {}

  public String getDocumento() {
    return documento;
  }

  public String getNome() {
    return nome;
  }

  public String getEmail() {
    return email;
  }

  public void setDocumento(String documento) {
    this.documento = documento;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
