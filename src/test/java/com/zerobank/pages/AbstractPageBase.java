package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    protected String emptyField;


    public AbstractPageBase(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "searchTerm")
    private WebElement search;

    @FindBy(xpath = "//button[@class='signin btn btn-info']")
    private WebElement signInButton;


    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    private  WebElement usernameElement;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;

    @FindBy(linkText = "Account Summary")
    private WebElement accountSummary;

    @FindBy(linkText = "Account Activity")
    private WebElement accountActivity;


    /**
     * This method return Top module is displayed or not
     * Account Summary, Account Activity, Transfer Funds, Pay Bills, My Money Map, Online Statements
     * @param moduleName
     * @return
     */
    public boolean isDisplayModule(String moduleName){

        return Driver.getDriver().findElement(By.linkText(moduleName)).isDisplayed();



    }





    Actions actions = new Actions(driver);

    public void clickLogoutButton(){
        usernameElement.click();
        actions.moveToElement(logout).perform();
        logout.click();
        BrowserUtilities.wait(1);

    }

    public void clickOnSignInButton(){
        signInButton.click();
    }

    public void sendKeysToSearch(String searchText){
        search.sendKeys(searchText);
    }


    /**
     * Method for module navigation. Provide tab module to navigate
     * @param moduleName like:
     *               Account Summary
     *               Account Activity
     *               Transfer Funds
     *               Pay Bills
     *               My Money Map
     *               Online Statements
     */
    public void navigateTo(String moduleName) {

        WebElement moduleElement = driver.findElement(By.linkText(moduleName));
        moduleElement.click();
    }






}
