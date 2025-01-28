package br.com.fiap.fiapeats.unitTests.usecases.dto;

import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class EditarProdutoResponseTest {

    @Test
    void criarEditarProdutoResponseComTodosOsCampos() {
        UUID id = UUID.randomUUID();
        EditarProdutoResponse response = new EditarProdutoResponse(id, "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");

        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNome()).isEqualTo("Produto 1");
        assertThat(response.getDescricao()).isEqualTo("Descrição 1");
        assertThat(response.getValor()).isEqualTo(BigDecimal.TEN);
        assertThat(response.getCategoria()).isEqualTo("Categoria 1");
        assertThat(response.getImagemUrl()).isEqualTo("imagem1.jpg");
    }

    @Test
    void criarEditarProdutoResponseComCamposNulos() {
        UUID id = UUID.randomUUID();
        EditarProdutoResponse response = new EditarProdutoResponse(id, null, null, null, null, null);

        assertThat(response.getId()).isEqualTo(id);
        assertThat(response.getNome()).isNull();
        assertThat(response.getDescricao()).isNull();
        assertThat(response.getValor()).isNull();
        assertThat(response.getCategoria()).isNull();
        assertThat(response.getImagemUrl()).isNull();
    }

    @Test
    void setIdAlteraId() {
        EditarProdutoResponse response = new EditarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        UUID newId = UUID.randomUUID();
        response.setId(newId);

        assertThat(response.getId()).isEqualTo(newId);
    }

    @Test
    void setNomeAlteraNome() {
        EditarProdutoResponse response = new EditarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setNome("Produto 2");

        assertThat(response.getNome()).isEqualTo("Produto 2");
    }

    @Test
    void setDescricaoAlteraDescricao() {
        EditarProdutoResponse response = new EditarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setDescricao("Descrição 2");

        assertThat(response.getDescricao()).isEqualTo("Descrição 2");
    }

    @Test
    void setValorAlteraValor() {
        EditarProdutoResponse response = new EditarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setValor(BigDecimal.valueOf(20));

        assertThat(response.getValor()).isEqualTo(BigDecimal.valueOf(20));
    }

    @Test
    void setCategoriaAlteraCategoria() {
        EditarProdutoResponse response = new EditarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setCategoria("Categoria 2");

        assertThat(response.getCategoria()).isEqualTo("Categoria 2");
    }

    @Test
    void setImagemUrlAlteraImagemUrl() {
        EditarProdutoResponse response = new EditarProdutoResponse(UUID.randomUUID(), "Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        response.setImagemUrl("imagem2.jpg");

        assertThat(response.getImagemUrl()).isEqualTo("imagem2.jpg");
    }

}
