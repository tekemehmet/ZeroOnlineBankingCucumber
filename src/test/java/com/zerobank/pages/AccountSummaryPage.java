package com.zerobank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage extends AbstractPageBase {


    public List<String> getHeaderName(){

        List<WebElement> headerNames = driver.findElements(By.xpath("//div[@class='offset2 span8']/h2"));
        List<String> headerNamesText = new ArrayList<>();
        for (WebElement headerName : headerNames){

            headerNamesText.add(headerName.getText());
        }
        return headerNamesText;
    }



    public List<String> getColumnNames() {

        List<WebElement> columnNames = driver.findElements(By.xpath("(//table)[3]//th"));
        List<String> columnNamesText = new ArrayList<>();
        for (WebElement columnName : columnNames) {

            columnNamesText.add(columnName.getText());

        }
        return columnNamesText;

    }

}
