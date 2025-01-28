package br.com.fiap.fiapeats.unitTests.usecases.dto;

import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CriarProdutoDTOTest {
    @Test
    void criarProdutoDTOComTodosOsCampos() {
        CriarProdutoDTO dto = new CriarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");

        assertThat(dto.getNome()).isEqualTo("Produto 1");
        assertThat(dto.getDescricao()).isEqualTo("Descrição 1");
        assertThat(dto.getValor()).isEqualTo(BigDecimal.TEN);
        assertThat(dto.getCategoria()).isEqualTo("Categoria 1");
        assertThat(dto.getImagemUrl()).isEqualTo("imagem1.jpg");
    }

    @Test
    void criarProdutoDTOComCamposNulos() {
        CriarProdutoDTO dto = new CriarProdutoDTO(null, null, null, null, null);

        assertThat(dto.getNome()).isNull();
        assertThat(dto.getDescricao()).isNull();
        assertThat(dto.getValor()).isNull();
        assertThat(dto.getCategoria()).isNull();
        assertThat(dto.getImagemUrl()).isNull();
    }

    @Test
    void setNomeAlteraNome() {
        CriarProdutoDTO dto = new CriarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        dto.setNome("Produto 2");

        assertThat(dto.getNome()).isEqualTo("Produto 2");
    }

    @Test
    void setDescricaoAlteraDescricao() {
        CriarProdutoDTO dto = new CriarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        dto.setDescricao("Descrição 2");

        assertThat(dto.getDescricao()).isEqualTo("Descrição 2");
    }

    @Test
    void setValorAlteraValor() {
        CriarProdutoDTO dto = new CriarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        dto.setValor(BigDecimal.valueOf(20));

        assertThat(dto.getValor()).isEqualTo(BigDecimal.valueOf(20));
    }

    @Test
    void setCategoriaAlteraCategoria() {
        CriarProdutoDTO dto = new CriarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        dto.setCategoria("Categoria 2");

        assertThat(dto.getCategoria()).isEqualTo("Categoria 2");
    }

    @Test
    void setImagemUrlAlteraImagemUrl() {
        CriarProdutoDTO dto = new CriarProdutoDTO("Produto 1", "Descrição 1", BigDecimal.TEN, "Categoria 1", "imagem1.jpg");
        dto.setImagemUrl("imagem2.jpg");

        assertThat(dto.getImagemUrl()).isEqualTo("imagem2.jpg");
    }
}
