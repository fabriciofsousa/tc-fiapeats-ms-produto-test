package br.com.fiap.fiapeats.external.persistence.repository;

import br.com.fiap.fiapeats.external.persistence.orm.PedidoEntity;
import java.util.UUID;

import br.com.fiap.fiapeats.external.persistence.orm.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, UUID> {
    @Query("SELECT p FROM PedidoEntity p WHERE p.statusPagamento.id = :idStatusPagamento")
    List<PedidoEntity> findAllByStatusPagamentoId(@Param("idStatusPagamento") Long idStatusPagamento);
}
