package br.com.fiap.fiapeats.adapter.out.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categoria")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriaEntity {

    @Id
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;


}
