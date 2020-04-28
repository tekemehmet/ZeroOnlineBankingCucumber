package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDefinitions {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();


    @Then("Verify that Account summary page title {string}")
    public void verify_that_Account_summary_page_title(String expectedTitle) {
        System.out.println("Verify that Account summary page title");
        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @Then("Verify that Account summary has {string},{string},{string} and {string}")
    public void verify_that_Account_summary_has_and(String string, String string2, String string3, String string4) {

        BrowserUtilities.waitForPageToLoad(10);

        List<String> expectedHeader = Arrays.asList(string,string2,string3,string4);

        BrowserUtilities.wait(3);

        Assert.assertEquals(expectedHeader,accountSummaryPage.getHeaderName());


    }

    @Then("Verify that Credit Accounts table have {string} , {string} and {string}")
    public void verify_that_Credit_Accounts_table_have_and(String string, String string2, String string3) {
        System.out.println("Verify that Credit Accounts table have "+string+ " , "+ string2 + " and "+string3);
        BrowserUtilities.waitForPageToLoad(10);

        List<String> expected = Arrays.asList(string,string2,string3);

        BrowserUtilities.wait(3);

        Assert.assertEquals(expected, accountSummaryPage.getColumnNames());

    }


}
