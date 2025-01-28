package br.com.fiap.fiapeats.unitTests.usecases.dto;

import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ProdutoResponseTest {

    @Test
    void criarProdutoResponseComTodosOsCampos() {
        UUID id = UUID.randomUUID();
        ProdutoResponse response = new ProdutoResponse(id, "Produto 1", "Descrição 1", "Categoria 1", BigDecimal.TEN, "imagem1.jpg");

        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNome()).isEqualTo("Produto 1");
        assertThat(response.getDescricao()).isEqualTo("Descrição 1");
        assertThat(response.getCategoria()).isEqualTo("Categoria 1");
        assertThat(response.getValor()).isEqualTo(BigDecimal.TEN);
        assertThat(response.getImagemUrl()).isEqualTo("imagem1.jpg");
    }

    @Test
    void criarProdutoResponseComCamposNulos() {
        UUID id = UUID.randomUUID();
        ProdutoResponse response = new ProdutoResponse(id, null, null, null, null, null);

        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNome()).isNull();
        assertThat(response.getDescricao()).isNull();
        assertThat(response.getCategoria()).isNull();
        assertThat(response.getValor()).isNull();
        assertThat(response.getImagemUrl()).isNull();
    }


    @Test
    void setNomeAlteraNome() {
        ProdutoResponse response = new ProdutoResponse(UUID.randomUUID(), "Produto 232", "Descrição 1", "Categoria 1", BigDecimal.TEN, "imagem1.jpg");

        assertThat(response.getNome()).isEqualTo("Produto 232");
    }

}
