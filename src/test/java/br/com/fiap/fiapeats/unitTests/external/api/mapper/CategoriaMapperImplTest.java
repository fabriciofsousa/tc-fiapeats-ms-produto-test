package br.com.fiap.fiapeats.unitTests.external.api.mapper;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.external.api.mapper.CategoriaMapperImpl;
import br.com.fiap.fiapeats.external.persistence.orm.CategoriaEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaMapperImplTest {

    private final CategoriaMapperImpl categoriaMapper = new CategoriaMapperImpl();

    @Test
    void toCategoriaFromCategoriaEntity_shouldReturnCategoria_whenCategoriaEntityIsValid() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(1L);
        categoriaEntity.setDescricao("Beverages");

        Categoria categoria = categoriaMapper.toCategoriaFromCategoriaEntity(categoriaEntity);

        assertEquals(1L, categoria.getId());
        assertEquals("Beverages", categoria.getDescricao());
    }

    @Test
    void toCategoriaFromCategoriaEntity_shouldReturnNull_whenCategoriaEntityIsNull() {
        Categoria categoria = categoriaMapper.toCategoriaFromCategoriaEntity(null);

        assertNull(categoria);
    }

    @Test
    void toCategoriaFromCategoriaEntity_shouldThrowException_whenCategoriaEntityDescricaoIsNull() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(null);
        categoriaEntity.setDescricao(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            categoriaMapper.toCategoriaFromCategoriaEntity(categoriaEntity);
        });

        assertEquals("Descricao não pode ser nula", exception.getMessage());
    }

    @Test
    void toCategoriaFromCategoriaEntity_shouldReturnCategoriaWithDefaultId_whenCategoriaEntityIdIsNull() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(null);
        categoriaEntity.setDescricao("Snacks");

        Categoria categoria = categoriaMapper.toCategoriaFromCategoriaEntity(categoriaEntity);

        assertNull(categoria.getId());
        assertEquals("Snacks", categoria.getDescricao());
    }

    @Test
    void toCategoriaFromCategoriaEntity_shouldReturnCategoriaWithTrimmedDescription_whenCategoriaEntityDescricaoHasLeadingAndTrailingSpaces() {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(3L);
        categoriaEntity.setDescricao("Desserts");

        Categoria categoria = categoriaMapper.toCategoriaFromCategoriaEntity(categoriaEntity);

        assertEquals(3L, categoria.getId());
        assertEquals("Desserts", categoria.getDescricao());
    }
}