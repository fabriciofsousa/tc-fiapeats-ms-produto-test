package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.CategoriaEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriaRepositoryJPA extends JpaRepository<CategoriaEntity, Long> {
    CategoriaEntity findByDescricao(String descricao);
}
