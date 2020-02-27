package step_definitions.vendor_bills_steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.vendor_bills_page.VendorBill_CreateBillPage;
import pages.vendor_bills_page.Vendors_Bills;
import utilities.Config;
import utilities.Driver;

public class CreateBill_steps {
    VendorBill_CreateBillPage createBill = new VendorBill_CreateBillPage();
    Vendors_Bills billMain = new Vendors_Bills();

    String expectedVendorName = Config.getProperty("vendorForSearch").toString();



    @Then("User click on create bill button")
    public void user_click_on_create_bill_button() throws InterruptedException {
        Thread.sleep(2000);
        billMain.createButton.click();
    }

    @Then("User press vendor dropdown field")
    public void user_press_vendor_dropdown_field() {
        createBill.vendorNameDropdown.click();
    }

    @Then("User click Search more")
    public void user_click_Search_more() {
        createBill.vendorNameDropdown_SearchMore.click();
    }

    @Then("User entering vendor name in search field")
    public void user_entering_vendor_name_in_search_field() {

        createBill.vendorName_Search_inAddVendor.sendKeys(expectedVendorName + Keys.ENTER);
    }

    @Then("User click on right vendor")
    public void user_click_on_right_vendor() throws InterruptedException {
        Thread.sleep(3000);
        createBill.vendorNumInSearch();
        createBill.correctVendor.click();
    }

    @Then("User click save button")
    public void user_click_save_button() throws InterruptedException {
        Thread.sleep(2000);
        createBill.saveButton.click();
    }

    @Then("User can observe new bill is created")
    public void user_can_observe_new_bill_is_created() {
        String actualVendorName = Driver.getDriver().findElement(By.xpath("//*[@class='o_form_uri o_field_widget o_required_modifier']")).getText().toLowerCase();
        String actualBillDate = Driver.getDriver().findElement(By.name("date_invoice")).getText();
        String actualDueDate = Driver.getDriver().findElement(By.name("date_due")).getText();

        Assert.assertEquals(actualVendorName, expectedVendorName);
    }

    @Then("User can see error message")
    public void user_can_see_error_message() {
        Assert.assertTrue(createBill.errorMessage.isDisplayed());
    }
}
