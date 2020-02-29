package pages.vendor_bills_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VendorBills_Search {


        public VendorBills_Search(){
            PageFactory.initElements(Driver.getDriver(),this);
        }

        @FindBy(xpath = "//div[@class='o_facet_values']/span")
        public WebElement searchResultText;

        public WebElement correctBillinList;

        public void setCorrectBill(){
            for (int i = 1; i <100 ; i++) {
                WebElement temp=Driver.getDriver().findElement(By.xpath("//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr["+i+"]/td[2]"));
                if (temp.getText().equalsIgnoreCase(searchResultText.getText())){
                    correctBillinList=Driver.getDriver().findElement(By.xpath("//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr["+i+"]/td[2]"));
                    break;
                }
            }
        }





    }

