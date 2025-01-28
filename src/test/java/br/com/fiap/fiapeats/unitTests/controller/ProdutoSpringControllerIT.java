package br.com.fiap.fiapeats.unitTests.controller;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.UUID;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@Sql(scripts = {"/sqlTest.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ProdutoSpringControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setup() {
        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Nested
    class CriarProdutoTests {

        @Test
        void criarProdutoComSucesso() {
            CriarProdutoRequest request = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Drink", "http://imagem.com/img.png");

            given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/fiapeats/produto")
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body(matchesJsonSchemaInClasspath("schemas/criarProdutoResponseSchema.json"));
        }

        @Test
        void naoDeveCriarProduto_CategoriaInvalida() {
            CriarProdutoRequest request = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Fake", "http://imagem.com/img.png");

            given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/fiapeats/produto")
                    .then()
                    .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                    .log().all()
                    .body("mensagem", equalTo("Categoria informada inválida"));
        }

        @Test
        void criarProdutoComErroDeValidacao() {
            CriarProdutoRequest request = new CriarProdutoRequest("", "", new BigDecimal("-5"), "", "");

            given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .post("/fiapeats/produto")
                    .then()
                    .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
        }
    }

    @Nested
    class EditarProdutoTests {

        @Test
        void editarProdutoComSucesso() {
            UUID id = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
            EditarProdutoRequest request = new EditarProdutoRequest("Refrigerante Atualizado", "Lata 500ml", new BigDecimal("6.99"), "Drink", "http://imagem.com/updated.png");

            given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .put("/fiapeats/produto/" + id)
                    .then()
                    .statusCode(HttpStatus.OK.value());
        }

        @Test
        void editarProdutoNaoEncontrado() {
            UUID id = UUID.randomUUID();
            EditarProdutoRequest request = new EditarProdutoRequest("Produto Inexistente", "Descricao", new BigDecimal("9.99"), "Categoria", "http://imagem.com/naoexiste.png");

            given()
                    .contentType(ContentType.JSON)
                    .body(request)
                    .when()
                    .put("/fiapeats/produto/" + id)
                    .then()
                    .statusCode(HttpStatus.NOT_FOUND.value());
        }
    }

    @Nested
    class RemoverProdutoTests {

        @Test
        void removerProdutoComSucesso() {
            UUID id = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");

            given()
                    .when()
                    .delete("/fiapeats/produto/" + id)
                    .then()
                    .statusCode(HttpStatus.NO_CONTENT.value());
        }

        @Test
        void removerProdutoNaoEncontrado() {
            UUID id = UUID.randomUUID();

            given()
                    .when()
                    .delete("/fiapeats/produto/" + id)
                    .then()
                    .statusCode(HttpStatus.NOT_FOUND.value());
        }
    }

    @Nested
    class ListarProdutosTests {

        @Test
        void listarTodosProdutosComSucesso() {
            given()
                    .when()
                    .get("/fiapeats/produto")
                    .then()
                    .statusCode(HttpStatus.OK.value());
        }

        @Test
        void listarProdutosPorCategoriaComSucesso() {
            given()
                    .when()
                    .get("/fiapeats/produto/categoria/Drink")
                    .then()
                    .statusCode(HttpStatus.OK.value());
        }
    }
}
