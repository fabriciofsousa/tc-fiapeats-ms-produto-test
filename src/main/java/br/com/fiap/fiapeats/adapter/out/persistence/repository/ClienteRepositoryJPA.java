package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.ClienteEntity;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, UUID> {}
