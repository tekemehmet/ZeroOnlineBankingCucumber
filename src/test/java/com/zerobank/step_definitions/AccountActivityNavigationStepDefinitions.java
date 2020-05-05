package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityNavigationPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

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
    public void the_page_should_be_displayed(String string) {
        BrowserUtilities.wait(2);
        accountActivityNavigationPage.displayedAccountActivity();
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        accountActivityNavigationPage.displayedAccountValueWithSame(string);
    }

    @When("the user clicks on {string} on the Account Summary page")
    public void the_user_clicks_on_on_the_Account_Summary_page(String string) {
        accountActivityNavigationPage.navigateTo("Account Summary");

    }
}
