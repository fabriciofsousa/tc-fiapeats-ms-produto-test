package br.com.fiap.fiapeats.adapter.in.controller.contracts.response.produto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EditarProdutoResponse {

    private UUID id;

    private String nome;

    private String descricao;

    private String categoria;

    private BigDecimal valor;

    private String imagemUrl;
}
