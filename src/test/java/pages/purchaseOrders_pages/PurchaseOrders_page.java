package pages.purchaseOrders_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PurchaseOrders_page {

    public PurchaseOrders_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[contains(text(), 'Purchases')]")
    public WebElement purchasesButton;

    @FindBy (xpath = "//span[contains(text(), 'Purchase Orders')]")
    public WebElement purchaseOrdersText;

    @FindBy (xpath = "//span[contains(text(), 'Purchase Orders')]/..")
    public WebElement purchaseOrdersButton;

    @FindBy(xpath = "//button[.='Cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//button[contains(text(), 'Import')]")
    public WebElement importButton;


}
