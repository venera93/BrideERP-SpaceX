package step_definitions.incomingProducts;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.products_page.IncomingProductsPage;

import java.util.List;

public class IncomingProductsPositiveSearch {
    IncomingProductsPage ipPage = new IncomingProductsPage();

    @Given("User is on Incoming Products home page")
    public void user_is_on_Incoming_Products_home_page() {
        ipPage.incomingProductsField.click();
    }

    @When("User is searching for an {string}")
    public void user_is_searching_for_an(String item) {
        ipPage.searchBox.sendKeys(item + Keys.ENTER);

    }
    @Then("User should see only searched {string}")
    public void user_should_see_only_searched(String item) {
        List<WebElement> searchList = ipPage.listOfSearchedItems;

        for (WebElement e: searchList) {
            Assert.assertTrue(e.getText().toLowerCase().contains(item), "Search result is not the same.");
        }
    }


}
