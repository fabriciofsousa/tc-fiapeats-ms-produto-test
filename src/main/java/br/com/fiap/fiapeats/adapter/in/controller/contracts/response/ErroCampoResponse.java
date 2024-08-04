package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErroCampoResponse {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String campo;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String violacao;
}
