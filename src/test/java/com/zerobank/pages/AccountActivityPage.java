package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityPage extends AbstractPageBase {

    @FindBy(xpath = "//select[@id='aa_accountId']/option")
    private List<WebElement> dropDrownElements;

    @FindBy(xpath = "//table//tr//th")
    private List<WebElement> tableHeaderElements;

    @FindBy(xpath = "//select[@id='aa_accountId']/option[1]")
    private WebElement defaultDropDownElement;


    public String getDefaultAccountType(){
        return defaultDropDownElement.getText();
    }


    public List<String> getTableColumnNames() {

        List<WebElement> columnNames = tableHeaderElements;
        List<String> columnNamesText = new ArrayList<>();
        for (WebElement columnName : columnNames){
            columnNamesText.add(columnName.getText());
        }
        return columnNamesText;

    }



}
