package pages.vendor_bills_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VendorBill_infoPage {

    public VendorBill_infoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@name='partner_id']")
    public WebElement vendorNameInBillsInfo;

    @FindBy(xpath = "//span[@name='amount_total']")
    public WebElement amountTotal;

}
