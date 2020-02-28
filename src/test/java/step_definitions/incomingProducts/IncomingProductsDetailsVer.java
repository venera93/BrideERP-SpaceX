package step_definitions.incomingProducts;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.products_page.IncomingProductsPage;

public class IncomingProductsDetailsVer {
    IncomingProductsPage ipPage = new IncomingProductsPage();
    @When("User is clicking on Incoming Products item")
    public void user_is_clicking_on_Incoming_Products_item() throws InterruptedException {
        Thread.sleep(2000);
        ipPage.incomingProductsProduct.click();

    }

    @Then("User should see details about the product")
    public void user_should_see_details_about_the_product() throws InterruptedException {
        Thread.sleep(4000);
        ipPage.incomingProductsProductDetail.click();
        Assert.assertTrue(ipPage.incomingProductsProductDetail.getText().contains(ipPage.incomingProductsProductDetailTitle.getText()), "Titles do not match");

    }
}
