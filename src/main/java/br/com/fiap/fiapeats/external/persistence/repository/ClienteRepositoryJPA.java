package br.com.fiap.fiapeats.external.persistence.repository;

import br.com.fiap.fiapeats.external.persistence.orm.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJPA extends JpaRepository<ClienteEntity, String> {}
