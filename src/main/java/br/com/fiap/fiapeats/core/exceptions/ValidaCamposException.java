package br.com.fiap.fiapeats.core.exceptions;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import java.util.Set;
import javax.validation.ConstraintViolation;

public class ValidaCamposException extends Exception {
  private Set<ConstraintViolation<PedidoRequest>> violacoes;

  public Set<ConstraintViolation<PedidoRequest>> getViolacoes() {
    return violacoes;
  }

  public void setViolations(Set<ConstraintViolation<PedidoRequest>> violations) {
    this.violacoes = violations;
  }
}
