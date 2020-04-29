package com.zerobank.step_definitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @And("Verify that Account summary should have as follows:")
    public void verify_that_Account_summary_should_have_as_follows(List<String> dataTable) {
        System.out.println("Verify that Account summary should have as follows:");
        System.out.println(dataTable);

        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);

        Assert.assertEquals(dataTable,accountSummaryPage.getPageHeaderName());

    }

    @Then("Verify that Credit Accounts table should have as follows:")
    public void verify_that_Credit_Accounts_table_should_have_as_follows(List<String> dataTable) {
        System.out.println("Verify that Credit Accounts table should have as follows:");
        System.out.println(dataTable);

        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);

        Assert.assertEquals(dataTable, accountSummaryPage.getTableColumnNames());

    }

}
