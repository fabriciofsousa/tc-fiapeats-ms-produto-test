package br.com.fiap.fiapeats.adapter.gateway.persistence.repository;

import br.com.fiap.fiapeats.adapter.gateway.persistence.orm.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, String> {}
