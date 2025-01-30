package br.com.fiap.fiapeats.unitTests.external.persistence.impl;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.external.persistence.impl.CategoriaRepositoryImpl;
import br.com.fiap.fiapeats.external.persistence.mapper.CategoriaEntityMapper;
import br.com.fiap.fiapeats.external.persistence.orm.CategoriaEntity;
import br.com.fiap.fiapeats.external.persistence.repository.CategoriaRepositoryJPA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class CategoriaRepositoryImplTest {

    @InjectMocks
    private CategoriaRepositoryImpl categoriaRepositoryImpl;

    @Mock
    private CategoriaRepositoryJPA categoriaRepositoryJPA;

    @Mock
    private CategoriaEntityMapper categoriaEntityMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void consultarCategoriaExistente() {
        Categoria categoria = new Categoria(new java.util.Random().nextLong(), "Bebidas");
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setDescricao("Bebidas");

        when(categoriaRepositoryJPA.findByDescricaoIgnoreCase("Bebidas")).thenReturn(Optional.of(categoriaEntity));
        when(categoriaEntityMapper.toCategoria(categoriaEntity)).thenReturn(categoria);

        Categoria result = categoriaRepositoryImpl.consultar(categoria);

        assertThat(result).isEqualTo(categoria);
    }

    @Test
    void categoriaToCategoriaEntityReturnsNullWhenCategoriaIsNull() {

        Categoria result = categoriaEntityMapper.toCategoria(null);

        assertThat(result).isNull();
    }

    @Test
    void consultarCategoriaInexistente() {
        Categoria categoria = new Categoria(new java.util.Random().nextLong(), "Alimentos");

        when(categoriaRepositoryJPA.findByDescricaoIgnoreCase("Alimentos")).thenReturn(Optional.empty());

        Categoria result = categoriaRepositoryImpl.consultar(categoria);

        assertThat(result).isNull();
    }

    @Test
    void consultarCategoriaComDescricaoNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Categoria(null, null);
        });
    }

    @Test
    void adicionarDescricao_shouldThrowException_whenDescricaoIsNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            Categoria.adicionarDescricao(null);
        });

        assertThat(exception.getMessage()).isEqualTo("Descricao não pode ser nula");
    }

    @ParameterizedTest
    @CsvSource({
            "bebidas, Bebidas",
            "comida, Comida",
            "BEBIDAS, Bebidas",
            "bEbIdAs, Bebidas"
    })
    void adicionarDescricao_shouldReturnCategoriaWithCapitalizedDescricao(String input, String expected) {
        Categoria categoria = Categoria.adicionarDescricao(input);

        assertThat(categoria).isNotNull();
        assertThat(categoria.getId()).isNull();
        assertThat(categoria.getDescricao()).isEqualTo(expected);
    }

}