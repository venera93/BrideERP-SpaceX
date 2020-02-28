package step_definitions.vendor_bills_steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.vendor_bills_page.Vendors_Bills;
import pages.vendor_bills_page.Vendors_Bills_EditBillPage;

public class EditBill_steps {
    Vendors_Bills_EditBillPage billEdit = new Vendors_Bills_EditBillPage();
    Vendors_Bills billMain = new Vendors_Bills();
    String itemForSearch = "glass";

    @Then("User click bill edit button")
    public void user_click_bill_edit_button() {
        billEdit.editButton.click();
    }

    @Then("User click add new item in a bill")
    public void user_click_add_new_item_in_a_bill() {
        billEdit.addItem.click();
    }

    @Then("User click on add item dropdown")
    public void user_click_on_add_item_dropdown() throws InterruptedException {
        billEdit.lastElement1();  /*should be last element, after all items*/
        Thread.sleep(2000);
        billEdit.addItemDropdownOpen.click();
    }

    @Then("User choosing search more items")
    public void user_choosing_search_more_items() {
        billEdit.searchMore.click();
    }

    @Then("User entering item for search and press enter")
    public void user_entering_item_for_search_and_press_enter() {
        billEdit.addItemSearch.sendKeys(itemForSearch + Keys.ENTER);
    }

    @Then("User click on right item")
    public void user_click_on_right_item() throws InterruptedException {
        Thread.sleep(2000);
        billEdit.itemNumInSearch();
        billEdit.correctItem.click();
    }

    @Then("User can observe new item inside the bill")
    public void user_can_observe_new_item_inside_the_bill() throws InterruptedException {
        Thread.sleep(3000);
        billEdit.lastElement2();/*should be last item*/
        String newIteminListText = billEdit.newItemInList.getAttribute("textContent");
        Assert.assertEquals(newIteminListText, itemForSearch);
    }
}
