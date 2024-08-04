package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.CategoriaEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositoryJPA extends JpaRepository<CategoriaEntity, Long> {
  Optional<CategoriaEntity> findByDescricao(String descricao);
}
