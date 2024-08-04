package br.com.fiap.fiapeats.adapter.handler;

import br.com.fiap.fiapeats.adapter.in.controller.contracts.request.PedidoRequest;
import br.com.fiap.fiapeats.adapter.in.controller.contracts.response.ErroResponse;
import br.com.fiap.fiapeats.core.exceptions.ValidaCamposException;
import java.util.Set;
import javax.validation.ConstraintViolation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ValidadorGlobalException {

  @ExceptionHandler(ValidaCamposException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  private ErroResponse fieldValidation(ValidaCamposException exception) {
    ErroResponse errorResponse = new ErroResponse();
    errorResponse.setTipo("ERRO_PARAMETROS_ENTRADA");
    errorResponse.setCodigo(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()));

    Set<ConstraintViolation<PedidoRequest>> violacoes = exception.getViolacoes();
    for (ConstraintViolation<PedidoRequest> violacao : violacoes) {
      errorResponse.incluirErroValidacao(
          violacao.getPropertyPath().toString(), violacao.getMessage());
    }
    log.error("Erro na chamada: {}", errorResponse);
    return errorResponse;
  }
}
