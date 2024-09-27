package br.com.fiap.fiapeats.external.persistence.repository;

import br.com.fiap.fiapeats.external.persistence.orm.CategoriaEntity;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositoryJPA extends JpaRepository<CategoriaEntity, Long> {
  Optional<CategoriaEntity> findByDescricao(String descricao);
}
