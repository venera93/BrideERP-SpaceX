package step_definitions.Products_stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.Login_page;
import pages.products_page.CreateProducts_page;
import utilities.Config;
import utilities.Driver;

public class CreateProduct_stepDef {

    Login_page login_page = new Login_page();
    CreateProducts_page createProduct = new CreateProducts_page();

    @Then("User on Purchases tab")
    public void userOnPurchasesTab() {
//        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
//        login_page.usernameInput.sendKeys(Config.getProperty("managerUsername"));
//        login_page.passwordInput.sendKeys(Config.getProperty("managerPassword"));
//        login_page.loginButton.click();
        createProduct.PurchasesTab.click();
    }

    @When("User clicks Products tab")
    public void userClicksProductsTab() {
        createProduct.ProductTap.click();

    }

    @And("User should able to see Create Btn")
    public void userShouldAbleToSeeCreateBtn() {
        Assert.assertTrue(createProduct.CreateBtn.isDisplayed());
    }

    @Given("User on Products tab under Purchases tab")
    public void userOnProductsTabUnderPurchasesTab() {

//        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
//        login_page.usernameInput.sendKeys(Config.getProperty("managerUsername"));
//        login_page.passwordInput.sendKeys(Config.getProperty("managerPassword"));
//        login_page.loginButton.click();
//        createProduct.PurchasesTab.click();
        createProduct.ProductTap.click();

    }

    @When("User clicks Create Btn")
    public void userClicksCreateBtn() {

        try{
            createProduct.alert.click();
        }catch (Exception e){

        }

        createProduct.CreateBtn.click();
    }

    @And("User should able to write new product name inside of  Product Name field")
    public void userShouldAbleToWriteNewProductNameInsideOfProductNameField() {
        createProduct.ProductNameField.sendKeys("Book");
    }


    @And("User should able to write cost of product inside of Cost field")
    public void userShouldAbleToWriteCostOfProductInsideOfCostField() {
        createProduct.CostField.click();
        createProduct.CostField.clear();
        createProduct.CostField.sendKeys("60.00");
    }

    @Then("User clicks save button")
    public void userClicksSaveButton() {
        createProduct.SaveBtn.click();
    }

    @And("User should able to see Product Template created message")
    public void userShouldAbleToSeeProductTemplateCreatedMessage() {
        org.testng.Assert.assertTrue(createProduct.ProductTemplateCreateMessage.isDisplayed());
    }

    @And("User clicks Edit button")
    public void userClicksEditButton() {
        createProduct.EditBtn.click();
    }

    @Given("User on Products tab")
    public void userOnProductsTab() {
//        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
//        login_page.usernameInput.sendKeys(Config.getProperty("managerUsername"));
//        login_page.passwordInput.sendKeys(Config.getProperty("managerPassword"));
//        login_page.loginButton.click();
//        createProduct.PurchasesTab.click();
        createProduct.ProductTap.click();

    }

    @And("User should leave empty Product Name field")
    public void userShouldLeaveEmptyProductNameField() {
        createProduct.ProductNameField.sendKeys("");
    }

    @Then("User clicks Save Btn")
    public void userClicksSaveBtn() {
        createProduct.SaveBtn.click();
    }

    @And("user should see warning popup")
    public void userShouldSeeWarningPopup() {
        Assert.assertTrue(createProduct.ErrorAlert.isDisplayed());
    }

}
