package br.com.fiap.fiapeats.adapter.out.persistence.impl;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.PedidoMapper;
import br.com.fiap.fiapeats.adapter.in.controller.mapper.ProdutoMapper;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoEntity;
import br.com.fiap.fiapeats.adapter.out.persistence.entities.PedidoProdutoID;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoProdutoRepositoryJPA;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.PedidoRepositoryJPA;
import br.com.fiap.fiapeats.adapter.out.persistence.repository.ProdutoRepositoryJPA;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProdutoRepositoryImpl implements ProdutoRepositoryPort {

  private final ProdutoMapper produtoMapper;
  private final ProdutoRepositoryJPA produtoRepositoryJPA;

  public ProdutoRepositoryImpl(ProdutoMapper produtoMapper, ProdutoRepositoryJPA produtoRepositoryJPA) {
    this.produtoMapper = produtoMapper;
    this.produtoRepositoryJPA = produtoRepositoryJPA;
  }

  @Override
  public Produto salvar(Produto produto) {
    return produtoMapper.entityToDomain(produtoRepositoryJPA
            .save(produtoMapper.domainToEntity(produto)));
  }

}
