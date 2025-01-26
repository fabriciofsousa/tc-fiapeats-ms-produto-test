package br.com.fiap.fiapeats.unitTests.gateway.persistence.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.adapter.gateway.persistence.interfaces.CategoriaRepository;
import br.com.fiap.fiapeats.adapter.gateway.persistence.impl.CategoriaRepositoryGatewayImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Random;

class CategoriaRepositoryGatewayImplTest {

    @InjectMocks
    private CategoriaRepositoryGatewayImpl categoriaRepositoryGateway;

    @Mock
    private CategoriaRepository categoriaRepository;

    private Categoria categoria;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        Random random = new Random();
        categoria = new Categoria(random.nextLong(), "Categoria Teste");
    }

    @Test
    void deveConsultarCategoriaComSucesso() {
        when(categoriaRepository.consultar(categoria)).thenReturn(categoria);

        Categoria resultado = categoriaRepositoryGateway.consultar(categoria);

        assertThat(resultado).isNotNull();
        assertThat(resultado.getDescricao()).isEqualTo("Categoria teste");
        verify(categoriaRepository, times(1)).consultar(categoria);
    }

    @Test
    void deveRetornarNuloQuandoCategoriaNaoEncontrada() {
        when(categoriaRepository.consultar(categoria)).thenReturn(null);

        Categoria resultado = categoriaRepositoryGateway.consultar(categoria);

        assertThat(resultado).isNull();
        verify(categoriaRepository, times(1)).consultar(categoria);
    }
}
