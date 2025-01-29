package br.com.fiap.fiapeats.unitTests.bdd;

import org.junit.platform.suite.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite  // NOSONAR
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SelectClasspathResource("features/produto.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "br.com.fiap.fiapeats.unitTests.bdd")
public class RunCucumberTest {
}