package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Then("user navigate to {string} module")
    public void user_navigate_to_module(String string) {
        BrowserUtilities.waitForPageToLoad(10);
        accountActivityPage.navigateTo("Account Activity");
    }



    @Then("Verify that Account Activity page title {string}")
    public void verify_that_Account_Activity_page_title(String expectedTitle) {
        System.out.println("Verify that Account Activity page title");

        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);

        Assert.assertEquals(expectedTitle,actualTitle);
    }



    @Then("Verify that Account drop down default is {string}")
    public void verify_that_Account_drop_down_default_is(String string) {
        System.out.println("Verify that Account drop down default is Saving");
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(string,accountActivityPage.getDefaultAccountType());



    }

    @Then("Verify that drop down should have following options:")
    public void verify_that_drop_down_should_have_following_options(List<String> dataTable) {
        System.out.println("Verify that drop down as list");
        System.out.println(dataTable);
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(dataTable,accountActivityPage.getDropDownList());

    }

    @Then("Verify that transactions table should have following options")
    public void verify_that_transactions_table_should_have_following_options(List<String> dataTable) {
        System.out.println("Verify that transactions table as list");
        System.out.println(dataTable);
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals(dataTable,accountActivityPage.getTableColumnNames());


    }
}
