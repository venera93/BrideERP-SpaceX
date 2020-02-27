package pages.vendor_bills_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class VendorBill_CreateBillPage {
    public VendorBill_CreateBillPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='o_field_widget o_field_many2one o_required_modifier']")
    public WebElement vendorNameDropdown;

    @FindBy(linkText = "Search More...")
    public WebElement vendorNameDropdown_SearchMore;

    @FindBy(xpath = "(//input[@placeholder='Search...'])[2]")
    public WebElement vendorName_Search_inAddVendor;

    @FindBy(xpath = "//*[@name='date_invoice']")
    public WebElement billDate;

    @FindBy(name = "date_due")
    public WebElement dueDate;

    public WebElement addItemDropdownOpen;
    public void lastElement1(){
        List list = Driver.getDriver().findElements(By.xpath("//*[@class='tab-pane active']/div[1]/div[2]/table/tbody/tr/td[2]/div/div/input"));
        addItemDropdownOpen= (WebElement) ((List) list).get(list.size()-1);
    }


    @FindBy(xpath = "//div[@class='o_searchview']/div[2]/div/span")
    public WebElement searchResult;


    public WebElement correctVendor;

    public  void vendorNumInSearch(){
        VendorBill_CreateBillPage vc=new VendorBill_CreateBillPage();

        WebElement item;
        for (int i = 1; i<100; i++) {
            item=Driver.getDriver().findElement(By.xpath("(//*[@class='modal o_technical_modal in']/div/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[1])"));
            //*[@class='modal o_technical_modal in']/div/div/div[2]/div[2]/div/table/tbody/tr[1]/td[1]
            if (item.getText().equalsIgnoreCase((String) Config.getProperty("vendorForSearch")/*vc.searchResult.getText().trim()*/)){
                correctVendor=Driver.getDriver().findElement(By.xpath("(//*[@class='modal o_technical_modal in']/div/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[1])"));
                break;
            }
        }
    }

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    @FindBy(xpath = "/html/body/div[2]/div")
    public WebElement errorMessage;
}
