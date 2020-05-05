
package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;
import java.util.Map;


public class PayBillsStepDefinitions {

    PayBillsPage payBillsPage = new PayBillsPage();

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

    @Then("Verify that error message {string} message")
    public void verify_that_error_message_message(String warningMessage) {

        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(warningMessage, payBillsPage.getRequiredFieldAlert());
    }


}




