package br.com.fiap.fiapeats.unitTests.bdd;

import br.com.fiap.fiapeats.external.api.contracts.request.CriarProdutoRequest;
import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ProdutoSteps {

    private CriarProdutoRequest criarProdutoRequest;
    private EditarProdutoRequest editarProdutoRequest;
    private UUID produtoId;
    private Response response;

    @Dado("que eu tenho os dados de um novo produto")
    public void queEuTenhoOsDadosDeUmNovoProduto() {
        criarProdutoRequest = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Bebida", "http://imagem.com/img.png");
    }

    @Dado("que eu tenho os dados de um novo produto com categoria inválida")
    public void queEuTenhoOsDadosDeUmNovoProdutoComCategoriaInvalida() {
        criarProdutoRequest = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Fake", "http://imagem.com/img.png");
    }

    @Dado("que eu tenho os dados de um novo produto com erro de validação")
    public void queEuTenhoOsDadosDeUmNovoProdutoComErroDeValidacao() {
        criarProdutoRequest = new CriarProdutoRequest("", "", new BigDecimal("-5"), "", "");
    }

    @Dado("que eu tenho os dados atualizados de um produto existente")
    public void queEuTenhoOsDadosAtualizadosDeUmProdutoExistente() {
        criarProdutoRequest = new CriarProdutoRequest("Refrigerante editado", "Lata 350ml editado", new BigDecimal("95.99"), "Bebida", "http://imagemEditada.com/img.png");
        String id = given()
                .contentType(ContentType.JSON)
                .body(criarProdutoRequest)
                .when()
                .post("/fiapeats/produto")
                .then().extract().path("id");;

        produtoId = UUID.fromString(id);

        editarProdutoRequest = new EditarProdutoRequest("Refrigerante Atualizado", "Lata 500ml", new BigDecimal("6.99"), "Bebida", "http://imagem.com/updated.png");
    }

    @Dado("que eu tenho os dados atualizados de um produto inexistente")
    public void queEuTenhoOsDadosAtualizadosDeUmProdutoInexistente() {
        produtoId = UUID.randomUUID();
        editarProdutoRequest = new EditarProdutoRequest("Produto Inexistente", "Descricao", new BigDecimal("9.99"), "Categoria", "http://imagem.com/naoexiste.png");
    }

    @Dado("que eu tenho o ID de um produto existente")
    public void queEuTenhoOIDDeUmProdutoExistente() {
        criarProdutoRequest = new CriarProdutoRequest("Refrigerante", "Lata 350ml", new BigDecimal("5.99"), "Bebida", "http://imagem.com/img.png");
        String id = given()
                .contentType(ContentType.JSON)
                .body(criarProdutoRequest)
                .when()
                .post("/fiapeats/produto")
                .then().extract().path("id");;

        produtoId = UUID.fromString(id);
    }

    @Dado("que eu tenho o ID de um produto inexistente")
    public void queEuTenhoOIDDeUmProdutoInexistente() {
        produtoId = UUID.randomUUID();
    }

    @Dado("que eu tenho uma categoria de produto existente")
    public void queEuTenhoUmaCategoriaDeProdutoExistente() {
        // No setup needed for this step
    }

    @Quando("eu envio uma solicitação para criar o produto")
    public void euEnvioUmaSolicitacaoParaCriarOProduto() {
        response = given()
                .contentType(ContentType.JSON)
                .body(criarProdutoRequest)
                .when()
                .post("/fiapeats/produto");
    }

    @Quando("eu envio uma solicitação para criar o produto com categoria inválida")
    public void euEnvioUmaSolicitacaoParaCriarOProdutoComCategoriaInvalida() {
        response = given()
                .contentType(ContentType.JSON)
                .body(criarProdutoRequest)
                .when()
                .post("/fiapeats/produto");
    }

    @Quando("eu envio uma solicitação para criar o produto com erro de validação")
    public void euEnvioUmaSolicitacaoParaCriarOProdutoComErroDeValidacao() {
        response = given()
                .contentType(ContentType.JSON)
                .body(criarProdutoRequest)
                .when()
                .post("/fiapeats/produto");
    }

    @Quando("eu envio uma solicitação para editar o produto")
    public void euEnvioUmaSolicitacaoParaEditarOProduto() {
        response = given()
                .contentType(ContentType.JSON)
                .body(editarProdutoRequest)
                .when()
                .put("/fiapeats/produto/" + produtoId);
    }

    @Quando("eu envio uma solicitação para editar o produto inexistente")
    public void euEnvioUmaSolicitacaoParaEditarOProdutoInexistente() {
        response = given()
                .contentType(ContentType.JSON)
                .body(editarProdutoRequest)
                .when()
                .put("/fiapeats/produto/" + produtoId);
    }

    @Quando("eu envio uma solicitação para remover o produto")
    public void euEnvioUmaSolicitacaoParaRemoverOProduto() {
        response = given()
                .when()
                .delete("/fiapeats/produto/" + produtoId);
    }

    @Quando("eu envio uma solicitação para remover o produto inexistente")
    public void euEnvioUmaSolicitacaoParaRemoverOProdutoInexistente() {
        response = given()
                .when()
                .delete("/fiapeats/produto/" + produtoId);
    }

    @Quando("eu envio uma solicitação para listar todos os produtos")
    public void euEnvioUmaSolicitacaoParaListarTodosOsProdutos() {
        response = given()
                .when()
                .get("/fiapeats/produto");
    }

    @Quando("eu envio uma solicitação para listar produtos por categoria")
    public void euEnvioUmaSolicitacaoParaListarProdutosPorCategoria() {
        response = given()
                .when()
                .get("/fiapeats/produto/categoria/Bebida");
    }

    @Então("o produto deve ser criado com sucesso")
    public void oProdutoDeveSerCriadoComSucesso() {
        response.then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Então("a criação do produto deve falhar com mensagem de categoria inválida")
    public void aCriacaoDoProdutoDeveFalharComMensagemDeCategoriaInvalida() {
        response.then()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .body("mensagem", equalTo("Categoria informada inválida"));
    }

    @Então("a criação do produto deve falhar com erro de validação")
    public void aCriacaoDoProdutoDeveFalharComErroDeValidacao() {
        response.then()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @Então("o produto deve ser editado com sucesso")
    public void oProdutoDeveSerEditadoComSucesso() {
        response.then()
                .statusCode(HttpStatus.OK.value());

        assertNotEquals(criarProdutoRequest, editarProdutoRequest, "Os produtos não são diferentes");

    }

    @Então("a edição do produto deve falhar com produto não encontrado")
    public void aEdicaoDoProdutoDeveFalharComProdutoNaoEncontrado() {
        response.then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Então("o produto deve ser removido com sucesso")
    public void oProdutoDeveSerRemovidoComSucesso() {
        response.then()
                .statusCode(HttpStatus.NO_CONTENT.value());
    }

    @Então("a remoção do produto deve falhar com produto não encontrado")
    public void aRemocaoDoProdutoDeveFalharComProdutoNaoEncontrado() {
        response.then()
                .statusCode(HttpStatus.NOT_FOUND.value());
    }

    @Então("a listagem de produtos deve ser bem-sucedida")
    public void aListagemDeProdutosDeveSerBemSucedida() {
        response.then()
                .statusCode(HttpStatus.OK.value());
    }

    @Então("a listagem de produtos por categoria deve ser bem-sucedida")
    public void aListagemDeProdutosPorCategoriaDeveSerBemSucedida() {
        response.then()
                .statusCode(HttpStatus.OK.value());
    }

    @Então("a remoção do produto deve falhar com uma mensagem de produto não encontrado")
    public void a_remoção_do_produto_deve_falhar_com_uma_mensagem_de_produto_não_encontrado() {
        response.then()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("mensagem", equalTo("Produto não encontrado"));
    }

    @Então("a criação do produto deve falhar com uma mensagem de categoria inválida")
    public void a_criação_do_produto_deve_falhar_com_uma_mensagem_de_categoria_inválida() {
        response.then()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                .body("mensagem", equalTo("Categoria informada inválida"));
    }

    @Então("a criação do produto deve falhar com um erro de validação")
    public void a_criação_do_produto_deve_falhar_com_um_erro_de_validação() {
        response.then()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @Então("a edição do produto deve falhar com uma mensagem de produto não encontrado")
    public void a_edição_do_produto_deve_falhar_com_uma_mensagem_de_produto_não_encontrado() {
        response.then()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .body("mensagem", equalTo("Produto não encontrado"));
    }
}