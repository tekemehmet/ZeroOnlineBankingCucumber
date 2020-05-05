package com.zerobank.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountActivityNavigationPage extends AbstractPageBase {

    @FindBy(xpath = "//table//td[1]")
    private List<WebElement> headerButtons;


    /**
     * This method displayed Account value
     *
     * @param accountListName
     */
    public boolean isDisplayedAccountValue(String accountListName){
        accountListName=accountListName.toLowerCase();
        Map<String,String> accountList= new HashMap<>();

        accountList.put("savings","1");
        accountList.put("checking","2");
        accountList.put("savings","3");
        accountList.put("loan","4");
        accountList.put("credit card","5");
        accountList.put("brokerage","6");

       return driver.findElement(By.xpath("//select[@class='input-xlarge']//option[@value='"+accountList.get(accountListName)+"']")).isDisplayed();

    }


    /**
     * This method click on Savings, Brokerage , Checking, Credit Card and Loan
     *
     * @param linkName
     */
    public void clickAccountSummaryHeaderButtons(String linkName) {

        WebElement headerName = driver.findElement(By.linkText(linkName));
        headerName.click();

    }

}


