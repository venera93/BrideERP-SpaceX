package step_definitions.vendors_stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Login_page;
import pages.vendors_page.Vendors_Page;
import utilities.Config;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;

public class vendors_stepDefs {
    Vendors_Page vp=new Vendors_Page();

    @Given("the user is login as a user")
    public void the_user_is_login_as_a_user() {

        Login_page login=new Login_page();
        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperty("briteUserName"));
        login.passwordInput.sendKeys(Config.getProperty("britePassword"));
        login.loginButton.click();


    }

    @When("user click on purchase tab")
    public void user_click_on_purchase_tab() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(vp.purchasesButton)).click();
    }

    @Then("user should see vendors tab")
    public void user_should_see_vendors_tab() {
        Assert.assertTrue(vp.vendorsButton.isDisplayed());


    }

    @Then("user should taken to the Vendors page after clicking Vendors tab")
    public void user_should_taken_to_the_Vendors_page_after_clicking_Vendors_tab() throws InterruptedException{
        SeleniumUtils.waitForVisibility(vp.vendorsButton,6000);
    vp.vendorsButton.click();
//        SeleniumUtils.waitForVisibility(vp.vendorPageTitle,8000);
        Thread.sleep(6000);
        Assert.assertEquals(vp.vendorPageTitle.getText(), "Vendors");


    }
    @When("user should be able to see the create button and click it")
    public void user_should_be_able_to_see_the_create_button_and_click_it() {
        Assert.assertTrue("Vendors create button doesn't displayed",vp.vendorCreateButton.isDisplayed());
        vp.vendorCreateButton.click();
    }

    @When("user should see individual radio button is selected as a default.")
    public void user_should_see_individual_radio_button_is_selected_as_a_default() {
        Assert.assertTrue("Individual radio button is not selected as a default",vp.vendorIndividualCheckBox.isSelected() );

    }

    @When("user enter a name into name field and click to Save button.")
    public void user_enter_a_name_into_name_field_and_click_to_Save_button() {
        vp.vendorNameField.sendKeys("Saime");
        vp.vendorSaveButton.click();

    }

    @Then("the entered name should display into the next page.")
    public void the_entered_name_should_display_into_the_next_page() {
        Assert.assertTrue(vp.vendorCreatedNameField.getText().equals("Saime"));
    }

    @When("User should be able to see the Search field left side of the page")
    public void user_should_be_able_to_see_the_Search_field_left_side_of_the_page() {
        Assert.assertTrue("Search field doesn't displayed",vp.vendorSearchField.isDisplayed());
    }

    @When("user enter a name into the search tab and click")
    public void user_enter_a_name_into_the_search_tab_and_click() throws InterruptedException {
        vp.vendorSearchField.sendKeys("Saime"+ Keys.ENTER);
        Thread.sleep(3000);
    }

    @Then("user should see relevant results are displayed.")
    public void user_should_see_relevant_results_are_displayed() {
        List<WebElement> searchResults=Driver.getDriver().findElements(By.xpath("//div[@class='oe_kanban_details']"));
        for(WebElement result: searchResults){
         if(result.getText().equals("Saime")){
         Assert.assertTrue(result.getText().equals("Saime"));
            }
        }
    }

}
