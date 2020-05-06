
package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;
import java.util.Map;


public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage = new PayBillsPage();

    private String dateOrAmount="";


    @Then("Verify that Pay Bills page title {string}")
    public void verify_that_Pay_Bills_page_title(String expectedTitle) {
        System.out.println("User navigates to Pay Bills module");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);

        System.out.println("Verify that Pay Bills page title");

        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    /**
     *        | Payee  | Account | Amount | Date       | Description  |
     *       | Sprint | Savings | 1000   | 2020-05-01 | Pay for Loan |
     * @param dataTable
     */

    @Then("user creates a payment with following info:")
    public void user_creates_a_payment_with_following_info( List<Map<String,String>> dataTable) {

        for (Map<String,String> row : dataTable){

                payBillsPage.setPayeeSelect(row.get("Payee"));
                payBillsPage.setAccountSelect(row.get("Account"));
                payBillsPage.setAmountSelect(row.get("Amount"));
                payBillsPage.setDateSelect(row.get("Date"));
                payBillsPage.setDescriptionSelect("Description");
            }
        }



    @Then("user click on Pay button")
    public void user_click_on_Pay_button() {

        payBillsPage.clickPayButton();
        BrowserUtilities.wait(1);
    }

    @Then("Verify that {string} message")
    public void verify_that_message(String expectedMessage) {

        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals(expectedMessage, payBillsPage.getMessage());

        }

    @Then("user creates a payment with missing info:")
    public void user_creates_a_payment_with_missing_info(List<Map<String,String>> dataTable) {

        if (dataTable.get(0).get("Amount")==null){
            dateOrAmount="Amount";
        }
        if (dataTable.get(0).get("Date")==null){
            dateOrAmount="Date";
        }

        for (Map<String,String> row : dataTable){
            payBillsPage.setPayeeSelect(row.get("Payee"));
            payBillsPage.setAccountSelect(row.get("Account"));
            payBillsPage.setAmountSelect(row.get("Amount"));
            payBillsPage.setDateSelect(row.get("Date"));
            payBillsPage.setDescriptionSelect("Description");
        }
    }

    @Then("Verify that error message {string}")
    public void verify_that_error_message(String warningMessage) {
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertEquals(warningMessage, payBillsPage.getPopUpAlert(dateOrAmount));
    }

    @Then("user navigate to PayBill submenu {string}")
    public void user_navigate_to_PayBill_submenu(String string) {
        System.out.println("User navigate to PayBill submenu Add New Payee");
        payBillsPage.navigateToUnderPayBills(string);
        BrowserUtilities.wait(3);
    }

    @Then("creates new payee using following information:")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        System.out.println("User creates new payee");
        BrowserUtilities.waitForPageToLoad(10);

        payBillsPage.setPayeeName(dataTable.get("Payee Name"));
        payBillsPage.setPayeeAddress(dataTable.get("Payee Address"));
        payBillsPage.setPayeeAccount(dataTable.get("Account"));
        payBillsPage.setPayeeDetails(dataTable.get("Payee Details"));

        BrowserUtilities.wait(2);
        payBillsPage.clickAddButton();

    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expected) {
        System.out.println("message verifying");
        Assert.assertEquals(expected,payBillsPage.getMessageNewPayee());

    }


}




