package stepsPO;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = {"src/test/resources/featuresPO"}, // Onde estão os cenarios em Gherkin
        glue = {"stepsPO"},                                 // Onde estão as definições de passos
        dryRun = false,                                    // Exibição de Log
        monochrome = true,                                // Detalhes do log
        plugin = {
                    "pretty",                            // Formatação visual do Cucumber
                "html:target/reports/extentreports",     // Saida Html do Relatório Simpless
                "json:target/reports/extentreports.json",      //Saida Json com os dados
                "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/reports/dashboard.html"

        }
)

public class Runner extends AbstractTestNGCucumberTests{//equivale ao @RunWith do JUnit
    // Configuração de modelo de relatório ou de outra característica
}
