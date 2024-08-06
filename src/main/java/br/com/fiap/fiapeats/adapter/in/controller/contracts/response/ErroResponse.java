package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErroResponse {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String tipo;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String codigo;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<ErroCampoResponse> validacoes;

  public void incluirErroValidacao(final String campo, final String violacao) {
    if (this.validacoes == null) {
      this.validacoes = new ArrayList<>();
    }
    this.validacoes.add(ErroCampoResponse.builder().campo(campo).violacao(violacao).build());
  }
}
