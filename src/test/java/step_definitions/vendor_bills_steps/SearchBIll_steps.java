package step_definitions.vendor_bills_steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.vendor_bills_page.VendorBill_infoPage;
import pages.vendor_bills_page.VendorBills_Search;
import pages.vendor_bills_page.Vendors_Bills;

public class SearchBIll_steps {
    VendorBills_Search searchBill = new VendorBills_Search();
    Vendors_Bills billMain = new Vendors_Bills();
    VendorBill_infoPage infoBill = new VendorBill_infoPage();

    String expectedVendorName = "abc";

    @Then("User entering bill name inside Search field")
    public void user_entering_bill_name_inside_Search_field() {

        billMain.searchInput.sendKeys(expectedVendorName + Keys.ENTER);

    }

    @Then("Correct bill should be present and user click on it")
    public void correct_bill_should_be_present_and_user_click_on_it() throws InterruptedException {
        Thread.sleep(2000);
        searchBill.setCorrectBill();
        searchBill.correctBillinList.click();
    }

    @Then("Bill page info is opened")
    public void bill_page_info_is_opened() {

        String actualVendorName = infoBill.vendorNameInBillsInfo.getText();

        Assert.assertTrue(expectedVendorName.equalsIgnoreCase(actualVendorName));
    }
}
