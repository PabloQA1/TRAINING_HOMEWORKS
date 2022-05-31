package AT.hw_7.steps;

import AT.hw_7.page_objects.HomePage;;
import AT.hw_7.page_objects.ResultsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchStepsDefs {

    @Given("^I opened ebay home page$")
    public void iOpenedEbayHomePage() {
        new HomePage().openPage();
    }

    @When("^I search the product \"([^\"]*)\"$")
    public void iSearchTheProduct(String itemName) {
        new HomePage().fillingSearchField(itemName)
                .clickOnTheSearchButton();
    }

    @Then("^The item \"([^\"]*)\" should be the first in the Search Result grid$")
    public void theItemShouldBeTheFirstInTheSearchResultGrid(String item) {
        Assert.assertTrue(new ResultsPage().getTextFromFirstProduct(item));
    }
}
