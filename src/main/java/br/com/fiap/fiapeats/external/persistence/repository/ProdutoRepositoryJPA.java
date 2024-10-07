package br.com.fiap.fiapeats.external.persistence.repository;

import br.com.fiap.fiapeats.external.persistence.orm.ProdutoEntity;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepositoryJPA extends JpaRepository<ProdutoEntity, UUID> {

  @Query("SELECT p FROM ProdutoEntity p WHERE p.categoria.id = :idCategoria")
  List<ProdutoEntity> findProductByCategoryId(@Param("idCategoria") Long idCategoria);
}
