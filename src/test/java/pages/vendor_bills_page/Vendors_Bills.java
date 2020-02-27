package pages.vendor_bills_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Vendors_Bills {
    public Vendors_Bills(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchInput;

    @FindBy(xpath = "(//td[@class='o_data_cell o_required_modifier'])[1]")
    public WebElement firstBillInList;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/tbody/tr[1]/td[8]")
    public WebElement amountOfFirstElement;
}
