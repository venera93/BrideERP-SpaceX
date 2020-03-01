package step_definitions.PurchaseOrders_edit_print_step_def;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.purchase_orders.PurchaseOrdersEdit;
import utilities.Driver;
import utilities.SeleniumUtils;

public class PurchaseOrders_edit_printstepDef {
    PurchaseOrdersEdit purchaseOrdersEdit = new PurchaseOrdersEdit();
    @When("user on purchases page")
    public void user_on_purchases_page() throws InterruptedException{
        Thread.sleep(5000);
        purchaseOrdersEdit.purchaseButton.click();
    }

    @When("user should able to click purchase orders button")
    public void user_should_able_to_click_purchase_orders_button() throws InterruptedException {
        Thread.sleep(5000);
        purchaseOrdersEdit.purchaseOrders.click();
        Thread.sleep(2000);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Purchase Orders - Odoo";
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Purchase orders title verification is failed");

    }

    @When("user should be  to click to one of orders from list")
    public void user_should_be_to_click_to_one_of_orders_from_list() throws InterruptedException{
        Thread.sleep(2000);
        purchaseOrdersEdit.orderFromPurchaseList.click();
        Thread.sleep(2000);
        String expectedTitleName = purchaseOrdersEdit.nameOfOrder.getText();
        String actualTitleName = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitleName.contains(expectedTitleName), "Title doesn't contain the order name");

    }

    @When("user click edit button")
    public void user_click_edit_button() {
        SeleniumUtils.waitForVisibility(purchaseOrdersEdit.editButton, 5);
        purchaseOrdersEdit.editButton.click();
    }

    @When("user enter Orders on the vendor reference field")
    public void user_enter_Orders_on_the_vendor_reference_field()throws InterruptedException {
        SeleniumUtils.waitForVisibility(purchaseOrdersEdit.addVenderReference, 5);
        purchaseOrdersEdit.addVenderReference.click();
        purchaseOrdersEdit.addVenderReference.sendKeys("Orders");
       Thread.sleep(2000);
    }

    @Then("user click save button")
    public void user_click_save_button() throws InterruptedException {
        Thread.sleep(5000);
        purchaseOrdersEdit.saveButton.click();
    }


    @When("user should be able to click print button")
    public void user_should_be_able_to_click_print_button() {
        SeleniumUtils.waitForVisibility(purchaseOrdersEdit.printButton, 5);
        purchaseOrdersEdit.printButton.click();
    }

    @Then("user click purchase order from print button option")
    public void user_click_purchase_order_from_print_button_option() {
        SeleniumUtils.waitForVisibility(purchaseOrdersEdit.purchaseOrderOptionFromPrintButton, 5);
        purchaseOrdersEdit.purchaseOrderOptionFromPrintButton.click();

    }





}
