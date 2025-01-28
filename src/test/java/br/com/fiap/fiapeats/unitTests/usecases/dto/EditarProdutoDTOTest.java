package br.com.fiap.fiapeats.unitTests.usecases.dto;

import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class EditarProdutoDTOTest {

    @Test
    void criarEditarProdutoDTOComTodosOsCampos() {
        UUID id = UUID.randomUUID();
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", id);

        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getNome()).isEqualTo("Produto 1");
        assertThat(dto.getDescricao()).isEqualTo("Descrição 1");
        assertThat(dto.getValor()).isEqualTo(BigDecimal.TEN);
        assertThat(dto.getCategoria()).isEqualTo("Categoria 1");
        assertThat(dto.getImagemUrl()).isEqualTo("imagem1.jpg");
    }

    @Test
    void criarEditarProdutoDTOComCamposNulos() {
        UUID id = UUID.randomUUID();
        EditarProdutoDTO dto = new EditarProdutoDTO(null, null, null, null, null, id);

        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getNome()).isNull();
        assertThat(dto.getDescricao()).isNull();
        assertThat(dto.getValor()).isNull();
        assertThat(dto.getCategoria()).isNull();
        assertThat(dto.getImagemUrl()).isNull();
    }

    @Test
    void setIdAlteraId() {
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", UUID.randomUUID());
        UUID newId = UUID.randomUUID();
        dto.setId(newId);

        assertThat(dto.getId()).isEqualTo(newId);
    }

    @Test
    void setNomeAlteraNome() {
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", UUID.randomUUID());
        dto.setNome("Produto 2");

        assertThat(dto.getNome()).isEqualTo("Produto 2");
    }

    @Test
    void setDescricaoAlteraDescricao() {
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", UUID.randomUUID());
        dto.setDescricao("Descrição 2");

        assertThat(dto.getDescricao()).isEqualTo("Descrição 2");
    }

    @Test
    void setValorAlteraValor() {
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", UUID.randomUUID());
        dto.setValor(BigDecimal.valueOf(20));

        assertThat(dto.getValor()).isEqualTo(BigDecimal.valueOf(20));
    }

    @Test
    void setCategoriaAlteraCategoria() {
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", UUID.randomUUID());
        dto.setCategoria("Categoria 2");

        assertThat(dto.getCategoria()).isEqualTo("Categoria 2");
    }

    @Test
    void setImagemUrlAlteraImagemUrl() {
        EditarProdutoDTO dto = new EditarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg", UUID.randomUUID());
        dto.setImagemUrl("imagem2.jpg");

        assertThat(dto.getImagemUrl()).isEqualTo("imagem2.jpg");
    }
}
