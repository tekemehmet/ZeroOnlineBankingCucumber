package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class will be extended by page classes
 * Any common web elements/locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 */

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,30);


    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchTerm")
    private WebElement search;

    @FindBy(xpath = "//button[@id='signin_button']")
    private WebElement signInButton;

    @FindBy(linkText = "Account Summary")
    private WebElement accountSummary;

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void sendKeysToSearch(String searchText){
        search.sendKeys(searchText);
    }

    public boolean displayedAccountSummary(){
        return accountSummary.isDisplayed();

    }




}
