package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("Open login page");
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
        loginPage.clickOnSignInButton();
        BrowserUtilities.wait(2);
    }

    @When("user logs in as a authorized user")
    public void user_logs_in_as_a_authorized_user() {
        System.out.println("Login as an authorized user");
        loginPage.login();
        BrowserUtilities.wait(2);
    }

    @When("authorized user should verify that {string} page is displayed")
    public void authorized_user_should_verify_that_page_is_displayed(String string) {
        System.out.println("authorized user should verify that Account Summary page is displayed");
        loginPage.isDisplayModule(string);
        BrowserUtilities.waitForPageToLoad(10);

    }


    @Then("user log out")
    public void user_log_out() {
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(2);
        loginPage.clickLogoutButton();
    }

    @And("user logs in as a  wrong username and wrong password")
    public void user_logs_in_as_a_wrong_username_and_wrong_password() {
        System.out.println("Login as a non-authorized user");
        loginPage.clickOnSignInButton();
        loginPage.login("mehmet","123456");
        BrowserUtilities.wait(2);
    }

    @Then("verify that error message should be displayed")
    public void verify_that_error_message_should_be_displayed() {
        String expected = "Login and/or password are wrong.";
        String actual = loginPage.getWarningMessage();
        BrowserUtilities.waitForPageToLoad(20);
        BrowserUtilities.wait(2);
        Assert.assertEquals(expected, actual);
    }

}
