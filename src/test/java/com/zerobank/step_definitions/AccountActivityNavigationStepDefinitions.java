package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityNavigationPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.concurrent.BrokenBarrierException;

public class AccountActivityNavigationStepDefinitions {

    AccountActivityNavigationPage accountActivityNavigationPage = new AccountActivityNavigationPage();

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        System.out.println("User click on "+string+ " on the Account Summary page");
        BrowserUtilities.waitForPageToLoad(5);
        BrowserUtilities.wait(1);
        accountActivityNavigationPage.clickAccountSummaryHeaderButtons(string);
    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String module) {
        BrowserUtilities.wait(2);
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertTrue(accountActivityNavigationPage.isDisplayModule(module));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String accountList) {
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertTrue(accountActivityNavigationPage.isDisplayedAccountValue(accountList));
    }

    @When("the user clicks on {string} on the Account Summary page")
    public void the_user_clicks_on_on_the_Account_Summary_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
