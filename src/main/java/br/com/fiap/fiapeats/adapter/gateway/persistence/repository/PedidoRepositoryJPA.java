package br.com.fiap.fiapeats.adapter.gateway.persistence.repository;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.PedidoEntity;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, UUID> {}
