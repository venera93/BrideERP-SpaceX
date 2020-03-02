package step_definitions.purchaseOrders_stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.purchaseOrders_pages.PurchaseOrders_page;
import utilities.Config;
import utilities.Driver;


public class PurchaseOrdersVerification {

    PurchaseOrders_page purchaseOrdersPage = new PurchaseOrders_page();


    @Given("user logged in and on home page")
    public void user_logged_in_and_on_home_page() throws InterruptedException {
//        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
//        Driver.getDriver().findElement(By.id("login")).sendKeys("in_pos_user6@info.com");
//        Driver.getDriver().findElement(By.id("password")).sendKeys("KjKtfgrs42");
//        Driver.getDriver().findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(2000);
        purchaseOrdersPage.purchasesButton.click();
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Odoo";
        Assert.assertTrue("Title verification fail", actualTitle.contains(expectedTitle));
    }

    @Then("verify purchase button is present on header menu options")
    public void verify_purchase_button_is_present_on_header_menu_options() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertTrue("Purchase button verification fail", purchaseOrdersPage.purchaseOrdersButton.isDisplayed());
    }

    @Then("purchase order option should be displayed under Purchase")
    public void purchase_order_option_should_be_displayed_under_Purchase() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("Purchase orders button verification fail", purchaseOrdersPage.purchaseOrdersButton.isDisplayed());
        Thread.sleep(2000);

    }

    @When("click on purchase order")
    public void click_on_purchase_order() {
            purchaseOrdersPage.purchaseOrdersButton.click();
    }

    @Then("user should be navigated to purchase orders landing page")
    public void user_should_be_navigated_to_purchase_orders_landing_page() throws InterruptedException {
        Thread.sleep(2000);

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Purchase Orders";
        Assert.assertTrue("Purchase orders title verification fail", actualTitle.contains(expectedTitle));

    }

    @Given("purchase orders landing page")
    public void purchase_orders_landing_page() throws InterruptedException {
        Thread.sleep(2000);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Purchase Orders";
        Assert.assertTrue("Purchase orders title verification fail", actualTitle.contains(expectedTitle));
    }

    @Then("import button should be displayed")
    public void import_button_should_be_displayed() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertTrue("Import button verification fail", purchaseOrdersPage.importButton.isDisplayed());
        Thread.sleep(2000);

    }

    @When("click on import button")
    public void click_on_import_button() {
        purchaseOrdersPage.importButton.click();
    }

    @Then("load file button should be displayed")
    public void load_file_button_should_be_displayed() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertTrue("Load button verification fail", purchaseOrdersPage.importButton.isDisplayed());
        Thread.sleep(2000);

    }

    @When("click cancel")
    public void click_cancel() {
        purchaseOrdersPage.cancelButton.click();
    }
}
