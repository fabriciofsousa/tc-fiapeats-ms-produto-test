package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ClienteEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepositoryJPA extends JpaRepository<ProdutoEntity, Long> {
}
