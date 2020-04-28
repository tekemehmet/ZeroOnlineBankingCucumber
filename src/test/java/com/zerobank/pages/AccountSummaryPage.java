package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class AccountSummaryPage extends AbstractPageBase {

    @FindBy(xpath = "//h2[text()='Cash Accounts']")
    private WebElement cashAccounts;

    @FindBy(xpath = "//h2[text()='Investment Accounts']")
    private WebElement investmentAccounts;

    @FindBy(xpath = "//h2[text()='Credit Accounts']")
    private WebElement creditAccounts;

    @FindBy(xpath = "//h2[text()='Loan Accounts']")
    private WebElement loanAccounts;

    public List<WebElement> getHeaderName(){

        List<WebElement> headerNames = driver.findElements(By.tagName("h2"));

        for (WebElement headerName : headerNames){
            System.out.println(headerName.getText());
        }
        return headerNames;
    }



    public List<WebElement> getColumnNames() {

        List<WebElement> columnNames = driver.findElements(By.xpath("(//table)[3]//th"));

        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());

        }
        return columnNames;

    }





    public String getCashAccountText(){
        return cashAccounts.getText();
    }

    public String getInvestmentAccountText(){
        return investmentAccounts.getText();
    }

    public String getCreditAccountText(){
        return creditAccounts.getText();
    }

    public String getLoanAccountText(){
        return loanAccounts.getText();
    }







}
