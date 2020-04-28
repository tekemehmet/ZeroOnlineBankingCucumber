package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;


public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("authorized user is on the login page")
    public void authorized_user_is_on_the_login_page() {
        System.out.println("Open login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.clickOnSignInButton();
    }

    @When("user logs in as a authorized user")
    public void user_logs_in_as_a_authorized_user() {
        System.out.println("Login as an authorized user");
        loginPage.login();
    }

    @Then("authorized user should verify that account summary page is displayed")
    public void authorized_user_should_verify_that_account_summary_page_is_displayed() {
        System.out.println("verify that account summary page is displayed");
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        Assert.assertTrue(loginPage.displayedAccountSummary());


    }

    @Given("non-authorized user is on the login page")
    public void non_authorized_user_is_on_the_login_page() {
        System.out.println("Open login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.clickOnSignInButton();
    }

    @When("user logs in as a  wrong username and wrong password")
    public void user_logs_in_as_a_wrong_username_and_wrong_password() {
        System.out.println("Login as a non-authorized user");
        loginPage.login("mehmet","123456");
    }

    @Then("verify that error message should be displayed")
    public void verify_that_error_message_should_be_displayed() {
        String expected = "Login and/or password are wrong.";
        String actual = loginPage.getWarningMessage();
        BrowserUtilities.waitForPageToLoad(20);
        BrowserUtilities.wait(5);
        Assert.assertEquals(expected, actual);
    }

}