package pages.products_page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UsersProductsPage {
    public UsersProductsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//a[@data-menu-xmlid='purchase.menu_purchase_root']")
    public WebElement purchasesButton;
    @FindBy (xpath = "//a[@data-action-id='691']")
    public WebElement productsButton;
    @FindBy (xpath = "//input[@class = 'o_searchview_input']")
    public WebElement productsSearchBox;
    @FindBy (css = "div.oe_view_nocontent")
    public WebElement wrongSearchMessage;
    @FindBy (xpath = "//span[@name='name']")
    public WebElement getRandomProductTitle;

}
