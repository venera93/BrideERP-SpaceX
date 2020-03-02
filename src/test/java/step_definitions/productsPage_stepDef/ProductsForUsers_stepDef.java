package step_definitions.productsPage_stepDef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Login_page;
import pages.products_page.UsersProductsPage;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Random;

public class ProductsForUsers_stepDef {
    UsersProductsPage usersProductsPage = new UsersProductsPage();
    Login_page login_page = new Login_page();

    @Given("User is on Brite ERP page")
    public void user_is_on_Brite_ERP_page() {
        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
    }

    @When("User enters username")
    public void user_enters_username() {
        login_page.usernameInput.sendKeys(Config.getProperty("ErpUsername"));
    }

    @When("User enters the password")
    public void user_enters_the_password() {
        login_page.passwordInput.sendKeys(Config.getProperty("ErpPassword"));
    }

    @When("User clicks on the Login button")
    public void user_clicks_on_the_Login_button() {
        login_page.loginButton.click();
    }

    @When("User clicks on the purchases module")
    public void user_clicks_on_the_purchases_module() {
        usersProductsPage.purchasesButton.click();
    }

    @When("User clicks on the Products tag")
    public void user_clicks_on_the_Products_tag() {
        usersProductsPage.productsButton.click();
    }

    @When("User should be able to see the title Products - Odoo")
    public void user_should_be_able_to_see_the_title_Products_Odoo() throws InterruptedException {
        Thread.sleep(8000);
        String actualTitleProductPage = Driver.getDriver().getTitle();
        String expectedTitleProductPage = "Products - Odoo";
        Assert.assertEquals(actualTitleProductPage, expectedTitleProductPage, "Titles of the PRODUCTS page do NOT match");
    }

    @And("User enters {string} on the search box")
    public void userEntersOnTheSearchBox(String inputValue) {
        usersProductsPage.productsSearchBox.sendKeys(inputValue, Keys.ENTER);
    }


    @When("User clicks on the cross button")
    public void user_clicks_on_the_cross_button() {
        List<WebElement> crosses = Driver.getDriver().findElements(By.xpath("//span[@class = 'o_searchview_facet_label']/following-sibling::div/following-sibling::div"));
        for (WebElement cross : crosses) {
            SeleniumUtils.waitForVisibility(cross, 3);
            cross.click();
        }
    }

    @When("User enters the {string}")
    public void user_enters_the(String inputWrongValue) {
        usersProductsPage.productsSearchBox.sendKeys(inputWrongValue, Keys.ENTER);
    }

    @Then("User sees a message")
    public void user_sees_a_message() {
        SeleniumUtils.waitForVisibility(usersProductsPage.wrongSearchMessage, 10);
        Assert.assertTrue(usersProductsPage.wrongSearchMessage.isDisplayed(), "The message for wrong item name is NOT displayed!");
    }

    @When("User clicks the product from the list")
    public void user_clicks_the_product_from_the_list() throws InterruptedException {
        Thread.sleep(5000);
        Random random = new Random();
        List<WebElement> productAll = Driver.getDriver().findElements(By.xpath("//div[@class = 'oe_kanban_global_click o_kanban_record']"));
        int productOne = random.nextInt(productAll.size());
        productAll.get(productOne).click();
    }

    @Then("User is navigated to the product description page")
    public void user_is_navigated_to_the_product_description_page() {
        SeleniumUtils.waitForVisibility(usersProductsPage.getRandomProductTitle, 10);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = usersProductsPage.getRandomProductTitle.getText() + " - Odoo";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Product's details' page title does NOT match");
    }

    @And("User clicks on the each tab")
    public void userClicksOnTheEachTab() throws InterruptedException {
        List<WebElement> tabs = Driver.getDriver().findElements(By.xpath("//a[@data-toggle='tab']"));
        for (WebElement tab : tabs) {
            if (!tab.getText().isEmpty()) {
                tab.click();
                Thread.sleep(2000);
                SeleniumUtils.waitForVisibility(tab, 2);
            }
        }
    }

}