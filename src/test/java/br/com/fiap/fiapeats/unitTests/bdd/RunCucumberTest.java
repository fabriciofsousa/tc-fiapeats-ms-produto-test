package br.com.fiap.fiapeats.unitTests.bdd;

import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.springframework.test.context.TestPropertySource;

@Suite
@SelectClasspathResource("features") // Utiliza o caminho do classpath para encontrar os arquivos .feature
@CucumberOptions(
        features = "classpath:features",
        glue = "br.com.fiap.fiapeats.unitTests.bdd",
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunCucumberTest {
}