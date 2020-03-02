package step_definitions.vendor_bills_steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.Login_page;
import pages.vendor_bills_page.VendorBill_infoPage;
import pages.vendor_bills_page.Vendors_Bills;
import utilities.Config;
import utilities.Driver;

public class Bill_Info_steps {

    Vendors_Bills billMain = new Vendors_Bills();
    VendorBill_infoPage infoBill = new VendorBill_infoPage();
    String amountTotalExpected;
    String vendorNameExpected;



    @Given("User is in Vendor Bill main page")
    public void user_is_in_Vendor_Bill_main_page() {

        Login_page login = new Login_page();
        Driver.getDriver().get(Config.getProperty("UrlBriteERP"));
        login.usernameInput.sendKeys(Config.getProperty("ErpUsername"));
        login.passwordInput.sendKeys(Config.getProperty("ErpPassword"));
        login.loginButton.click();
        Driver.getDriver().get("http://app2.briteerp.com/web#view_type=list&model=account.invoice&menu_id=515&action=687");
    }

    @Then("User pic first bill in list")
    public void user_pic_first_bill_in_list() throws InterruptedException {
        Thread.sleep(2000);
         vendorNameExpected = billMain.firstBillInList.getText();
         amountTotalExpected = billMain.amountOfFirstElement.getText();
        billMain.firstBillInList.click();
    }

    @Then("User can see new page with vendor bill info")
    public void user_can_see_new_page_with_vendor_bill_info() {
        String actualVendorName = infoBill.vendorNameInBillsInfo.getText();
        String actualAmountTotal = infoBill.amountTotal.getText();

        Assert.assertEquals(actualAmountTotal, amountTotalExpected);
        Assert.assertEquals(actualVendorName, vendorNameExpected);
    }
}
