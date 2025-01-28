package br.com.fiap.fiapeats.unitTests.performance;

import io.gatling.javaapi.core.ActionBuilder;
import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import java.time.Duration;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;
import static io.gatling.javaapi.http.HttpDsl.status;

public class ApiPerformanceSimulation extends Simulation {

    private final HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8080")
            .header("Content-Type", "application/json");

    ActionBuilder criarProdutoRequest = http("Criar Produto")
            .post("/fiapeats/produto")
            .body(StringBody("{ \"nome\": \"Refrigerante\", \"descricao\": \"Lata 350ml\", \"preco\": 5.99, \"categoria\": \"Bebida\", \"imagemUrl\": \"http://imagem.com/img.png\" }"))
            .check(status().is(201))
            .check(jsonPath("$.id").saveAs("produtoId"));

    ActionBuilder editarProdutoRequest = http("Editar Produto")
            .put("/fiapeats/produto/#{produtoId}")
            .body(StringBody("{ \"nome\": \"Refrigerante Atualizado\", \"descricao\": \"Lata 500ml\", \"preco\": 6.99, \"categoria\": \"Bebida\", \"imagemUrl\": \"http://imagem.com/updated.png\" }"))
            .check(status().is(200));

    ActionBuilder removerProdutoRequest = http("Remover Produto")
            .delete("/fiapeats/produto/#{produtoId}")
            .check(status().is(204));

    ActionBuilder listarProdutosRequest = http("Listar Produtos")
            .get("/fiapeats/produto")
            .check(status().is(200));

    ScenarioBuilder cenarioCriarProduto = scenario("Criar Produto")
            .exec(criarProdutoRequest);

    ScenarioBuilder cenarioEditarProduto = scenario("Editar Produto")
            .exec(criarProdutoRequest)
            .exec(editarProdutoRequest);

    ScenarioBuilder cenarioRemoverProduto = scenario("Remover Produto")
            .exec(criarProdutoRequest)
            .exec(removerProdutoRequest);

    ScenarioBuilder cenarioListarProdutos = scenario("Listar Produtos")
            .exec(listarProdutosRequest);

    {
        setUp(
                cenarioCriarProduto.injectOpen(
                        rampUsersPerSec(1).to(10).during(Duration.ofSeconds(10)),
                        constantUsersPerSec(10).during(Duration.ofSeconds(60)),
                        rampUsersPerSec(10).to(1).during(Duration.ofSeconds(10))),
                cenarioEditarProduto.injectOpen(
                        rampUsersPerSec(1).to(10).during(Duration.ofSeconds(10)),
                        constantUsersPerSec(10).during(Duration.ofSeconds(60)),
                        rampUsersPerSec(10).to(1).during(Duration.ofSeconds(10))),
                cenarioRemoverProduto.injectOpen(
                        rampUsersPerSec(1).to(10).during(Duration.ofSeconds(10)),
                        constantUsersPerSec(10).during(Duration.ofSeconds(60)),
                        rampUsersPerSec(10).to(1).during(Duration.ofSeconds(10))),
                cenarioListarProdutos.injectOpen(
                        rampUsersPerSec(1).to(100).during(Duration.ofSeconds(10)),
                        constantUsersPerSec(100).during(Duration.ofSeconds(60)),
                        rampUsersPerSec(100).to(1).during(Duration.ofSeconds(10))))
                .protocols(httpProtocol)
                .assertions(
                        global().responseTime().max().lt(50),
                        global().failedRequests().count().is(0L));
    }
}