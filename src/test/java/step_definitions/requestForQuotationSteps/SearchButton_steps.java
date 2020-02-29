package step_definitions.requestForQuotationSteps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.requestForQuotaton_page.CreateButton_pages;
import pages.requestForQuotaton_page.SearchButton_pages;
import utilities.Driver;

public class SearchButton_steps {
   SearchButton_pages searchButton_pages = new SearchButton_pages();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

    @When("User should be able to see search field and search title inside")
    public void user_should_be_able_to_see_search_field_and_search_title_inside() {
        searchButton_pages.requestForQuotationLink.click();
        wait.until(ExpectedConditions.visibilityOf(searchButton_pages.searchField));
        Assert.assertTrue(searchButton_pages.searchField.isDisplayed());
    }

    @When("User click and enter valid input")
    public void user_click_and_enter_valid_input() {
        searchButton_pages.searchField.click();
        searchButton_pages.searchField.sendKeys("ACD");
        Assert.assertTrue(searchButton_pages.optionsForSearch.isDisplayed());
    }



    @Then("User click enter")
    public void user_click_enter() {
        searchButton_pages.findByVendor.click();
    }

    @Then("User should be able to see related result")
    public void user_should_be_able_to_see_related_result() {
        Assert.assertTrue(searchButton_pages.relatedResultForVendor.isDisplayed(), "Related result is not there");

    }


}
