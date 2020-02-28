package pages.requestForQuotaton_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchButton_pages {
    public SearchButton_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_root']")
    public WebElement purchaseTab;

    @FindBy (xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_rfq']")
    public WebElement requestForQuotationLink;

    @FindBy (xpath = "//input[@class = 'o_searchview_input']")
    public WebElement searchField;

    @FindBy (xpath = "//ul[@class = 'dropdown-menu o_searchview_autocomplete']")
    public WebElement optionsForSearch;

    @FindBy(xpath = "//em[.='Vendor']")
    public WebElement findByVendor;

    @FindBy (xpath = "//tbody[@class = 'ui-sortable']")
    public WebElement relatedResultForVendor;

}
