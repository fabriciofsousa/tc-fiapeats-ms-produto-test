package br.com.fiap.fiapeats.adapter.in.controller.contracts.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IdentificarClienteResponse {

    private String nome;

    private String email;

    private String documento;

}
