package br.com.fiap.fiapeats.unitTests.external.api.exceptions;

import br.com.fiap.fiapeats.external.api.exceptions.RestErrorResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class RestErrorResponseTest {

  @Test
  void deveCriarRestErrorResponseComMensagemEListaDeErros() {
    String mensagem = "Erro de validação";
    List<String> erros = Arrays.asList("Campo obrigatório", "Formato inválido");

    RestErrorResponse response = new RestErrorResponse(mensagem, erros);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isEqualTo(erros);
    assertThat(response.getTimestamp()).isNotZero();
  }

  @Test
  void deveCriarRestErrorResponseComMensagemESemErros() {
    String mensagem = "Erro de validação";

    RestErrorResponse response = new RestErrorResponse(mensagem, null);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isNull();
    assertThat(response.getTimestamp()).isNotZero();
  }

  @Test
  void deveCriarRestErrorResponseComListaVaziaDeErros() {
    String mensagem = "Erro de validação";
    List<String> erros = Collections.emptyList();

    RestErrorResponse response = new RestErrorResponse(mensagem, erros);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isEqualTo(erros);
    assertThat(response.getTimestamp()).isNotZero();
  }

  @ParameterizedTest
  @NullSource
  @ValueSource(strings = {"Erro de validação"})
  void deveCriarRestErrorResponseComMensagemESemErros(String mensagem) {
    RestErrorResponse response = new RestErrorResponse(mensagem, null);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isNull();
    assertThat(response.getTimestamp()).isNotZero();
  }

  @Test
  void deveCriarRestErrorResponseComMensagemNula() {
    List<String> erros = Arrays.asList("Campo obrigatório", "Formato inválido");

    RestErrorResponse response = new RestErrorResponse(null, erros);

    assertThat(response.getMessage()).isNull();
    assertThat(response.getErrors()).isEqualTo(erros);
    assertThat(response.getTimestamp()).isNotZero();
  }
}