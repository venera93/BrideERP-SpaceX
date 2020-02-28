package step_definitions.incoming_products_create_import;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.incoming_products_pages.Icoming_Products_Create_Import_page;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class Incoming_Products_Create {
    Icoming_Products_Create_Import_page pagesIncoming = new Icoming_Products_Create_Import_page();

    @Given("User is on purchase Module")
    public void user_is_on_purchase_Module() {
        pagesIncoming.purchaseTab.click();

    }

    @Given("User is on Incoming products tab")
    public void user_is_on_Incoming_products_tab() throws Exception{
        pagesIncoming.incomingProductsField.click();
        Thread.sleep(3000);
        // I was not able to click on create button unless put some Thread.sleep; other waits both did not work
    }

    @When("user clicks on Create button from Incoming Products")
    public void user_clicks_on_Create_button_from_Incoming_Priducts() {
        pagesIncoming.createButtonIncomingProducts.click();
    }


    @When("User fills all required fields")
    public void user_fills_all_required_fields() throws Exception {
        pagesIncoming.referenceSourceLocationInput.click();
        Thread.sleep(1000);
        pagesIncoming.searchMore_ReferenceSourceLocationInput.click();
        //Here to make it dynamic I am using random generator to select random fromlist
//====================================
        // I select search more button from dropdown and it displays a table of location lists
        List<WebElement> elementsOfReference = Driver.getDriver().findElements(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr"));
        // System.out.println(elementsOfReference);
        int boundary1 = elementsOfReference.size();
        Random randomNum = new Random();
        int index1 = randomNum.nextInt(boundary1);
        // System.out.println(randomNum.nextInt(boundary));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+ index1+ "]"))));
        Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+ index1+ "]")).click();
//=====================================
        pagesIncoming.destinationLocationInput.click();
        pagesIncoming.seacrMore_DestinationLocation.click();
        List<WebElement> elementsOfDestination = Driver.getDriver().findElements(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr"));
        int boundry2 = elementsOfDestination.size();
        //System.out.println(elementsOfDestination);
        int index2 = randomNum.nextInt(boundry2);
        // System.out.println(index2);
        wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf( Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+index2+"]"))));
        Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive'])[3]//tbody/tr["+index2+"]")).click();
//======================================
        pagesIncoming.productInput.click();
        pagesIncoming.searchMore_Product.click();
        List<WebElement> elementsOfProduct = Driver.getDriver().findElements(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr"));
        int boundry3 = elementsOfProduct.size();
        //  System.out.println(elementsOfProduct);
        int index3 = randomNum.nextInt(boundry3);
        // System.out.println(index3);
        wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr["+ index3+"]"))));
        Driver.getDriver().findElement(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr["+ index3+"]")).click();
//========================================
        pagesIncoming.initialDemandInput.clear();
        pagesIncoming.initialDemandInput.sendKeys("100");

        pagesIncoming.sourceDocumentInput.sendKeys("From Abdumalik");
//==========================================
        pagesIncoming.procurementDocInput.click();
        pagesIncoming.searchMore_Procurement.click();
        List<WebElement> elementsOfProcurement = Driver.getDriver().findElements(By.xpath("(//div[@class ='table-responsive'])[3]//tbody/tr"));
        int boundry4 = elementsOfProcurement.size();
        //  System.out.println(elementsOfProcurement);
        int index4 = randomNum.nextInt(boundry4);
        //System.out.println(index4);
        wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive']//tbody)[3]/tr["+index4+"]"))));
        Driver.getDriver().findElement(By.xpath("(//div[@class='table-responsive']//tbody)[3]/tr["+index4+"]")).click();
//===============================================
    }

    @When("User saves changes")
    public void user_saves_changes() {
        pagesIncoming.saveButtonForCreateIncomingProducts.click();

    }

    @Then("User sees the new created file")
    public void user_sees_the_new_created_file() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),3);
        wait.until(ExpectedConditions.visibilityOf(pagesIncoming.actionBtnAfterCreate));

        Assert.assertTrue(pagesIncoming.actionBtnAfterCreate.isDisplayed(),"Action Btn is not displayed, Verification failed");
    }

    @Then("User sees pupUp warning")
    public void user_sees_pupUp_warning() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 3);
        wait.until(ExpectedConditions.visibilityOf(pagesIncoming.popUpWarning));
        Assert.assertTrue(pagesIncoming.popUpWarning.isDisplayed());
    }
    @When("user clicks on Import button from Incoming Products")
    public void user_clicks_on_Import_button_from_Incoming_Products() {
        pagesIncoming.importButton.click();
    }

    @Then("User is on Import page in Incoming Products")
    public void user_is_on_Import_page_in_Incoming_Products() {
        Assert.assertTrue(pagesIncoming.importInput.isDisplayed(), "Imort input button is not displayed");

    }
}
