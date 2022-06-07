package AT.hw_9;

import AT.hw_9.browser.Browser;
import AT.hw_9.custom_utils.CustomRunner;
import cucumber.api.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(CustomRunner.class)
@CucumberOptions(
        glue = "AT.hw_9",
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

