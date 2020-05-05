package com.zerobank.pages;

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

        switch (accountListName) {
            case "Savings":
                accountList.get(0).isDisplayed();
                break;
            case "Brokerage":
                accountList.get(2).isDisplayed();
                break;
            case "Checking":
                accountList.get(3).isDisplayed();
                break;
            case "Credit Card":
                accountList.get(4).isDisplayed();
                break;
            case "Loan":
                accountList.get(5).isDisplayed();
                break;
            default:
                throw new RuntimeException("Wrong name!");
        }

    }

    public boolean displayedAccountActivity(){
        return accountActivity.isDisplayed();
    }


    public void clickAccountSummaryHeaderButtons(String LinkName) {

        switch (LinkName) {
            case "Savings":
                headerButtons.get(0).click();
                break;
            case "Brokerage":
                headerButtons.get(2).click();
                break;
            case "Checking":
                headerButtons.get(3).click();
                break;
            case "Credit Card":
                headerButtons.get(4).click();
                break;
            case "Loan":
                headerButtons.get(5).click();
                break;
            default:
                throw new RuntimeException("Wrong name!");
        }

    }

}


