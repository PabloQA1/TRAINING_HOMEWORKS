package AT.hw_7.steps;

import AT.hw_7.page_objects.CartPayments;
import AT.hw_7.page_objects.ProductPage;
import AT.hw_7.page_objects.ResultsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class CartStepsDefs {

    @And("^I click to first product on the page$")
    public void iClickToFirstProductOnThePage() {
        new ResultsPage().goToFirstProductPage();
    }

    @Then("^The item \"([^\"]*)\" should be in the cart$")
    public void theItemShouldBeInTheCart(String item)  {
        Assert.assertTrue(new CartPayments().getTextFromProductInCart(item));
    }

    @And("^I click to the add product to the card button and cart page is opening$")
    public void iClickToTheAddProductToTheCardButtonAndCartPageIsOpening() {
        new ProductPage().addToTheCart();
    }
}
