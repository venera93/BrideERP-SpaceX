package step_definitions.reporting_stepDef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.Login_page;
import pages.reporting_page.ReportingTab_page;
import utilities.Config;
import utilities.Driver;

public class ReportingTab_verification {

    Login_page login_page = new Login_page();
    ReportingTab_page reportingTab_page = new ReportingTab_page();

    @Given("the user is login as a manager")
    public void the_user_is_login_as_a_manager() {
        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
        login_page.usernameInput.sendKeys(Config.getProperty("managerUsername"));
        login_page.passwordInput.sendKeys(Config.getProperty("managerPassword"));
        login_page.loginButton.click();
    }

    @When("user clicks on Purchase tab")
    public void user_clicks_on_Purchase_tab() {
        reportingTab_page.PurchasesTab.click();

    }

    @Then("user should see Reporting tab")
    public void user_should_see_Reporting_tab() {
        Assert.assertTrue("Reporting tab is not displayed!!",reportingTab_page.ReportingTab.isDisplayed());

    }

    @Then("user should taken to the Purchase Analysis page after clicking Reporting tab")
    public void user_should_taken_to_the_Purchase_Analysis_page_after_clicking_Reporting_tab() {
        reportingTab_page.ReportingTab.click();
    }
}
