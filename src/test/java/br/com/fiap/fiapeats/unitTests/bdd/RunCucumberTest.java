package br.com.fiap.fiapeats.unitTests.bdd;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import io.cucumber.spring.CucumberContextConfiguration;


import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite  // NOSONAR
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.fiap.fiapeats.unitTests.bdd")
public class RunCucumberTest {

    @LocalServerPort
    private static int port;
    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = System.getProperty("base.url");
        System.setProperty("base.url", "http://localhost:" + port);
    }
}