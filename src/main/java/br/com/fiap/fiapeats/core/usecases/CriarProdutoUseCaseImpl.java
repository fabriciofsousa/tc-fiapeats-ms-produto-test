package br.com.fiap.fiapeats.core.usecases;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.PedidoResponse;
import br.com.fiap.fiapeats.core.domain.Pedido;
import br.com.fiap.fiapeats.core.domain.Produto;
import br.com.fiap.fiapeats.core.ports.in.CriarProdutoUseCasePort;
import br.com.fiap.fiapeats.core.ports.out.PedidoRepositoryPort;
import br.com.fiap.fiapeats.core.ports.out.ProdutoRepositoryPort;
import br.com.fiap.fiapeats.core.utils.Constants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Component
public class CriarProdutoUseCaseImpl implements CriarProdutoUseCasePort {

  private final ProdutoRepositoryPort produtoRepositoryPort;

  public CriarProdutoUseCaseImpl(ProdutoRepositoryPort produtoRepositoryPort) {
    this.produtoRepositoryPort = produtoRepositoryPort;
  }

  @Override
  public Produto criar(Produto produto) {
    return produtoRepositoryPort.salvar(produto);
  }
}
