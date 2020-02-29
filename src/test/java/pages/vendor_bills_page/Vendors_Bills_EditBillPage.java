package pages.vendor_bills_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Vendors_Bills_EditBillPage {
    int itemNumINSearch;
    public Vendors_Bills_EditBillPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@accesskey='a']")
    public WebElement editButton;

    @FindBy(linkText = "Search More...")
    public WebElement searchMoreVendors;

    @FindBy (xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement vendorName;

    @FindBy(xpath = "(//input[@placeholder ='Search...'])[2]")
    public WebElement searchVendors;

    @FindBy(linkText = "Add an item")
    public WebElement addItem;

    public WebElement addItemDropdownOpen;
    public void lastElement1(){
        List list = Driver.getDriver().findElements(By.xpath("//*[@class='tab-pane active']/div[1]/div[2]/table/tbody/tr/td[2]/div/div/input"));
        addItemDropdownOpen= (WebElement) list.get(((List) list).size()-1);
    }
    @FindBy(linkText = "Search More...")
    public WebElement searchMore;

    @FindBy(xpath = "//*[@class='modal o_technical_modal in']/div/div/div[2]/div[1]/div[1]/input")
    public WebElement addItemSearch;

    @FindBy(xpath = "//div[@class='o_facet_values']/span")
    public WebElement searchResult;

    public WebElement correctItem;

    public   void itemNumInSearch(){
        Vendors_Bills_EditBillPage vb=new Vendors_Bills_EditBillPage();

        WebElement item=null;
        for (int i = 1; i<100; i++) {
            item=Driver.getDriver().findElement(By.xpath("(//*[@class='modal o_technical_modal in']/div/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[2])"));
            if (item.getText().equalsIgnoreCase(vb.searchResult.getText().trim())){
                correctItem=Driver.getDriver().findElement(By.xpath("(//*[@class='modal o_technical_modal in']/div/div/div[2]/div[2]/div/table/tbody/tr["+i+"]/td[2])"));
                break;
            }
        }
    }

    @FindBy(xpath = "//button[@accesskey='s']")
    public WebElement saveButton;

    public WebElement newItemInList;
    public void lastElement2(){
        ArrayList<WebElement> list = (ArrayList<WebElement>) Driver.getDriver().findElements(By.xpath("//*[@class='tab-pane active']/div[1]/div[2]/table/tbody/tr/td[2]"));
        newItemInList=list.get(list.size()-1);
    }

}
