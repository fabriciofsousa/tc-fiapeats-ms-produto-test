package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoryJPA extends JpaRepository<PedidoEntity, UUID> {}
