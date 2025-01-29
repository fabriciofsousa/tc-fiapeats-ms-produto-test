package br.com.fiap.fiapeats.unitTests.usecases.dto;

import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class CriarProdutoResponseTest {

    @Test
    void criarProdutoResponseComTodosOsCampos() {
        UUID id = UUID.randomUUID();
        CriarProdutoResponse response = new CriarProdutoResponse(id, "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");

        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNome()).isEqualTo("Produto 1");
        assertThat(response.getDescricao()).isEqualTo("Descrição 1");
        assertThat(response.getValor()).isEqualTo(BigDecimal.TEN);
        assertThat(response.getCategoria()).isEqualTo("Categoria 1");
        assertThat(response.getImagemUrl()).isEqualTo("imagem1.jpg");
    }

    @Test
    void criarProdutoResponseComCamposNulos() {
        UUID id = UUID.randomUUID();
        CriarProdutoResponse response = new CriarProdutoResponse(id, null, null, null, null, null);

        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNome()).isNull();
        assertThat(response.getDescricao()).isNull();
        assertThat(response.getValor()).isNull();
        assertThat(response.getCategoria()).isNull();
        assertThat(response.getImagemUrl()).isNull();
    }

    @Test
    void setIdAlteraId() {
        CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        UUID newId = UUID.randomUUID();
        response.setId(newId);

        assertThat(response.getId()).isEqualTo(newId);
    }

    @Test
    void setNomeAlteraNome() {
        CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setNome("Produto 2");

        assertThat(response.getNome()).isEqualTo("Produto 2");
    }

    @Test
    void setDescricaoAlteraDescricao() {
        CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setDescricao("Descrição 2");

        assertThat(response.getDescricao()).isEqualTo("Descrição 2");
    }

    @Test
    void setValorAlteraValor() {
        CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setValor(BigDecimal.valueOf(20));

        assertThat(response.getValor()).isEqualTo(BigDecimal.valueOf(20));
    }

    @Test
    void setCategoriaAlteraCategoria() {
        CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setCategoria("Categoria 2");

        assertThat(response.getCategoria()).isEqualTo("Categoria 2");
    }

    @Test
    void setImagemUrlAlteraImagemUrl() {
        CriarProdutoResponse response = new CriarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setImagemUrl("imagem2.jpg");

        assertThat(response.getImagemUrl()).isEqualTo("imagem2.jpg");
    }
}
