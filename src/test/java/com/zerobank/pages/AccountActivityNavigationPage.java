package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class AccountActivityNavigationPage extends AbstractPageBase {

    @FindBy(xpath = "//table//td[1]")
    private List<WebElement> headerButtons;

    @FindBy(linkText = "Account Activity")
    private WebElement accountActivity;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[1]")
    private List<WebElement> accountList;


    public void displayedAccountValueWithSame(String accountListName){



    }

    public boolean displayedAccountActivity(){

        return accountActivity.isDisplayed();
    }


    public void clickAccountSummaryHeaderButtons(String linkName) {

        WebElement headerName = driver.findElement(By.linkText(linkName));
        headerName.click();



    }

}


