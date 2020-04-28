package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Collection;
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

    public List<String> getHeaderName(){

        List<WebElement> headerNames = driver.findElements(By.tagName("h2"));
        List<String> headerNamesText = null;
        for (WebElement headerName : headerNames){
            System.out.println(headerName.getText());
            headerNamesText.add(headerName.getText());
        }
        return headerNamesText;
    }



    public List<String> getColumnNames() {

        List<WebElement> columnNames = driver.findElements(By.xpath("(//table)[3]//th"));
        List<String> columnNamesText = null;
        for (WebElement columnName : columnNames) {

            columnNamesText.add(columnName.getText());

        }
        return columnNamesText;

    }

}
