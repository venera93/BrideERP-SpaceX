package step_definitions.incomingProducts;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;
import org.testng.Assert;
import pages.Login_page;
import pages.products_page.IncomingProductsPage;
import utilities.Config;
import utilities.Driver;

public class IncomingProductsHomeVerStepDef {
IncomingProductsPage ipPage = new IncomingProductsPage();
Login_page login = new Login_page();
    @Given("User is logged in")
    public void user_is_logged_in() {

        Driver.getDriver().get("http://app.briteerp.com/web/login#view_type=kanban&model=crm.lead&action=366");
        login.usernameInput.sendKeys("in_pos_user6@info.com");
        login.passwordInput.sendKeys("KjKtfgrs42");
        login.loginButton.click();
    }

    @Given("User is on Purchases function")
    public void user_is_on_Purchases_function()  {
        ipPage.purchases.click();


    }

    @When("User is clicking on Incoming Products module")
    public void user_is_clicking_on_Incoming_Products_module() {
        ipPage.incomingProductsField.click();
    }

    @Then("User should be navigated to Incoming Products page")
    public void user_should_be_navigated_to_Incoming_Products_page() throws InterruptedException {
        String incomingProductsTitle = "Incoming Products";
        Thread.sleep(4000);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Incoming Products"));
    }







}
