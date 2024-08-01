package br.com.fiap.fiapeats.adapter.out.persistence.repository;

import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoProdutoRepositoryJPA
    extends JpaRepository<PedidoProdutoEntity, PedidoProdutoID> {}
