package br.com.fiap.fiapeats.adapter.controller;

import br.com.fiap.fiapeats.adapter.presenters.PagamentoPresenter;
import br.com.fiap.fiapeats.domain.entities.Pagamento;
import br.com.fiap.fiapeats.usecases.dtos.*;
import br.com.fiap.fiapeats.usecases.interfaces.in.pagamento.CriarPagamentoUseCase;

public class PagamentoController {

  private final CriarPagamentoUseCase criarPagamentoUseCase;

  public PagamentoController(CriarPagamentoUseCase criarPagamentoUseCase) {
    this.criarPagamentoUseCase = criarPagamentoUseCase;
  }

  public CriarPagamentoResponse criarPagamento(CriarPagamentoDTO criarPagamentoDTO) {
    Pagamento pagamento = criarPagamentoUseCase.criar(criarPagamentoDTO);

    return PagamentoPresenter.toCriarPagamentoResponse(pagamento);
  }
}
