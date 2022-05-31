package AT.hw_7;

import AT.hw_7.browser.Browser;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/bdd_features",
        plugin = {
                "pretty",
                "json:target/Cucumber.json",
                "html:target/cucumber-html-report"
        }
)

public class RunAcceptanceTest {

        @AfterClass
        public static void closeDriver() {
                Browser.close();
        }
}
