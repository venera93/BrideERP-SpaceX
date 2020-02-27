package step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.testng.annotations.Test;
import pages.requestForQuotaton_page.request_pages;
import utilities.Config;
import utilities.Driver;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RequestForQuotation_Steps {

  request_pages request_pages = new request_pages();
  WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);



    @Given("Request for quotation page")
    public void request_for_quotation_page() {
        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
        request_pages.loginField.sendKeys(Config.getProperty("ErpUsername"));
        request_pages.passwordField.sendKeys(Config.getProperty("ErpPassword"));
        request_pages.LoginButton.click();

        wait.until(ExpectedConditions.visibilityOf(request_pages.purchaseTab));

        request_pages.purchaseTab.click();

    }

    @When("User click create button")
    public void user_click_create_button() {
        Assert.assertTrue(request_pages.createButton.isDisplayed(), "Create button is not displayed");
        request_pages.createButton.click();
       Assert.assertTrue(request_pages.createField.isDisplayed());

        String expcetedCreatePageTitle = "New - Odoo";
        Assert.assertEquals(Driver.getDriver().getTitle(), expcetedCreatePageTitle);

    }

    @When("User filled out mandatory fields")
    public void user_filled_out_mandatory_fields() {
        Assert.assertTrue(request_pages.vendorField.isDisplayed());
        Assert.assertTrue(request_pages.vendorField.getAttribute("value").isEmpty(), "Vendor is not empty");
        request_pages.vendorField.click();
        request_pages.elementVendor.click();


        String expectDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalTime expectTime = LocalTime.now().minusSeconds(1);
        String changeTime = expectTime.format(DateTimeFormatter.ISO_TIME).substring(0, 8);
        String expectedDateTime = expectDate + " " + changeTime;
        System.out.println(expectedDateTime);
        //       Assert.assertEquals(mondayProjectPages.calendarValue.getAttribute("value"),expectedDateTime);
        System.out.println(request_pages.calendarValue.getText());
        //   Assert.assertTrue(!mondayProjectPages.calendarValue.getText().isEmpty(),"Time is empty");
        request_pages.deliveriesAndInvoices.click();


        Assert.assertTrue(request_pages.scheduleDate.getAttribute("value").isEmpty(), "Schedule date is not empty");
        request_pages.scheduleDate.sendKeys(expectedDateTime);

    }

    @When("User click  save button")
    public void user_click_save_button() {
        request_pages.saveButton.click();
    }

    @Then("User should be able to see Quotation number")
    public void user_should_be_able_to_see_Quotation_number() {
    }


    @Then("It should display error message")
    public void it_should_display_error_message() {
       Assert.assertTrue(request_pages.errorMessage.isDisplayed());
    }


    @When("User should be able to see search field and search title inside")
    public void user_should_be_able_to_see_search_field_and_search_title_inside() {
        request_pages.requestForQuotationLink.click();
        wait.until(ExpectedConditions.visibilityOf(request_pages.searchField));
        Assert.assertTrue(request_pages.searchField.isDisplayed());
    }

    @When("User click and enter valid input")
    public void user_click_and_enter_valid_input() {
        request_pages.searchField.click();
        request_pages.searchField.sendKeys("ACD");
        Assert.assertTrue(request_pages.optionsForSearch.isDisplayed());
    }



    @Then("User click enter")
    public void user_click_enter() {
        request_pages.findByVendor.click();
    }

    @Then("User should be able to see related result")
    public void user_should_be_able_to_see_related_result() {
        Assert.assertTrue(request_pages.relatedResultForVendor.isDisplayed(), "Related result is not there");

    }




}
