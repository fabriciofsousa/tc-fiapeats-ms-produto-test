package br.com.fiap.fiapeats.unitTests.external.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import br.com.fiap.fiapeats.domain.entities.Produto;
import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import br.com.fiap.fiapeats.external.api.mapper.ProdutoMapperImpl;
import br.com.fiap.fiapeats.usecases.dtos.CriarProdutoDTO;
import br.com.fiap.fiapeats.usecases.dtos.EditarProdutoDTO;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

class ProdutoMapperImplTest {

    private final ProdutoMapperImpl produtoMapper = new ProdutoMapperImpl();

    @Test
    void toCriarProdutoDTO_shouldReturnCriarProdutoDTO_whenCriarProdutoRequestIsValid() {
        CriarProdutoRequest request = new CriarProdutoRequest();
        request.setNome("Produto A");
        request.setDescricao("Descricao A");
        request.setValor(new BigDecimal("10.00"));
        request.setCategoria("Categoria A");
        request.setImagemUrl("http://example.com/imagem.jpg");

        CriarProdutoDTO dto = produtoMapper.toCriarProdutoDTO(request);

        assertEquals("Produto A", dto.getNome());
        assertEquals("Descricao A", dto.getDescricao());
        assertEquals(new BigDecimal("10.00"), dto.getValor());
        assertEquals("Categoria A", dto.getCategoria());
        assertEquals("http://example.com/imagem.jpg", dto.getImagemUrl());
    }

    @Test
    void toCriarProdutoDTO_shouldReturnNull_whenCriarProdutoRequestIsNull() {
        CriarProdutoDTO dto = produtoMapper.toCriarProdutoDTO(null);

        assertNull(dto);
    }
    @Test
    void deveCriarProdutoComId() {
        UUID id = UUID.randomUUID();
        Produto produto = new Produto(id);

        assertEquals(id, produto.getId(), "Must be equals");
    }
    @Test
    void toEditarProdutoDTO_shouldReturnEditarProdutoDTO_whenIdAndEditarProdutoRequestAreValid() {
        UUID id = UUID.randomUUID();
        EditarProdutoRequest request = new EditarProdutoRequest();
        request.setNome("Produto B");
        request.setDescricao("Descricao B");
        request.setValor(new BigDecimal("20.00"));
        request.setCategoria("Categoria B");
        request.setImagemUrl("http://example.com/imagem2.jpg");

        EditarProdutoDTO dto = produtoMapper.toEditarProdutoDTO(id, request);

        assertEquals(id, dto.getId());
        assertEquals("Produto B", dto.getNome());
        assertEquals("Descricao B", dto.getDescricao());
        assertEquals(new BigDecimal("20.00"), dto.getValor());
        assertEquals("Categoria B", dto.getCategoria());
        assertEquals("http://example.com/imagem2.jpg", dto.getImagemUrl());
    }

    @Test
    void toEditarProdutoDTO_shouldReturnNull_whenIdAndEditarProdutoRequestAreNull() {
        EditarProdutoDTO dto = produtoMapper.toEditarProdutoDTO(null, null);

        assertNull(dto);
    }

    @Test
    void toEditarProdutoDTO_shouldReturnEditarProdutoDTOWithNullFields_whenEditarProdutoRequestFieldsAreNull() {
        UUID id = UUID.randomUUID();
        EditarProdutoRequest request = new EditarProdutoRequest();

        EditarProdutoDTO dto = produtoMapper.toEditarProdutoDTO(id, request);

        assertEquals(id, dto.getId());
        assertNull(dto.getNome());
        assertNull(dto.getDescricao());
        assertNull(dto.getValor());
        assertNull(dto.getCategoria());
        assertNull(dto.getImagemUrl());
    }
}