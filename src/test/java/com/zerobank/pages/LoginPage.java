package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPageBase {

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement warningMessage;


    /**
     * This login is Authorized User
     * Positive test scenario
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
    }

    /**
     *  This is for specific user login method
     *  You can use for Negative test scenario
     * @param userNameValue
     * @param passwordValue
     */
    public void login(String userNameValue, String passwordValue){
        username.sendKeys(userNameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
    }

    public String getWarningMessage(){

        return warningMessage.getText();
    }


}
