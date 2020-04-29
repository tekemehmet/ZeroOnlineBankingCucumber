package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends AbstractPageBase {

    @FindBy(xpath = "//select[@id='sp_payee']")
    private WebElement payeeSelect;

    @FindBy(xpath = "//select[@id='sp_account']")
    private WebElement accountSelect;

    @FindBy(css = "#sp_amount")
    private  WebElement amountSelect;

    @FindBy(css = "#sp_date")
    private WebElement dateSelect;

    @FindBy(css = "#sp_description")
    private WebElement descriptionSelect;

    @FindBy(css = "#pay_saved_payees")
    private WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']/span")
    private WebElement messageElements;



    Select select;

    public void setPayeeSelect(String payee){
        select = new Select(payeeSelect);
        select.selectByValue(payee);
    }

    public void setAccountSelect(String account){
        select = new Select(accountSelect);
        select.selectByValue(account);
    }

    public void setAmountSelect(String amount){
        amountSelect.sendKeys(amount);
    }

    public void setDateSelect(String date){
        dateSelect.sendKeys(date);
    }

    public void setDescriptionSelect(String description){
        descriptionSelect.sendKeys(description);
    }

    public void clickPayButton(){
        payButton.click();
    }

    public String getMessage(){
        return messageElements.getText();
    }


}
