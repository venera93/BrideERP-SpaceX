package step_definitions.incomingProducts;

import cucumber.api.java.en.And;
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

@Given("User is on Incoming Products home page")
public void user_is_on_Incoming_Products_home_page(){
            Login_page login = new Login_page();
        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperty("ErpUsername"));
        login.passwordInput.sendKeys(Config.getProperty("ErpPassword"));
        login.loginButton.click();
    Driver.getDriver().get("http://app2.briteerp.com/web#view_type=list&model=stock.move&menu_id=514&action=519");
}

    @Then("User should be navigated to Incoming Products page")
    public void user_should_be_navigated_to_Incoming_Products_page() throws InterruptedException {
        String incomingProductsTitle = "Incoming Products";
        Thread.sleep(4000);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Incoming Products"));
    }

}
