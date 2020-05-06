package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.BaseRowSet;

public class PayBillsPage extends AbstractPageBase {

    @FindBy(xpath = "//select[@id='sp_payee']")
    private WebElement payeeSelect;

    @FindBy(xpath = "//select[@id='sp_account']")
    private WebElement accountSelect;

    @FindBy(css = "#sp_amount")
    private WebElement amountSelect;

    @FindBy(css = "#sp_date")
    private WebElement dateSelect;

    @FindBy(css = "#sp_description")
    private WebElement descriptionSelect;

    @FindBy(css = "#pay_saved_payees")
    private WebElement payButton;

    @FindBy(id = "alert_content")
    private WebElement messageElements;

    @FindBy(css = "#np_new_payee_name")
    private WebElement payeeName;

    @FindBy(css = "#np_new_payee_address")
    private WebElement payeeAddress;

    @FindBy(css = "#np_new_payee_account")
    private WebElement payeeAccount;

    @FindBy(css = "#np_new_payee_details")
    private WebElement payeeDetails;

    @FindBy(css = "#alert_content")
    private WebElement addPayeeAlertMessage;

    @FindBy(css = "#add_new_payee")
    private WebElement addButton;

    public void clickAddButton(){
        addButton.click();
    }

    public void setPayeeName(String payeeName){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("np_new_payee_name"))).sendKeys(payeeName);
    }

    public void setPayeeAddress(String payeeAddressFromTable){
        payeeAddress.sendKeys(payeeAddressFromTable);
        BrowserUtilities.wait(1);

    }

    public void setPayeeAccount(String payeeAccountFromTable){
        payeeAccount.sendKeys(payeeAccountFromTable);
        BrowserUtilities.wait(1);

    }

    public void setPayeeDetails(String payeeDetailsFromTable){
        payeeDetails.sendKeys(payeeDetailsFromTable);
        BrowserUtilities.wait(1);

    }

    public String getMessageNewPayee(){
        return addPayeeAlertMessage.getText();
    }



    Select select;

    public void setPayeeSelect(String payee) {
        select = new Select(payeeSelect);
        select.selectByVisibleText(payee);
    }

    public void setAccountSelect(String account) {
        select = new Select(accountSelect);
        select.selectByVisibleText(account);
    }

    public void setAmountSelect(String amount) {
        if (amount == null) {
            amount = "";
        }

        amountSelect.sendKeys(amount);
    }


    public void setDateSelect(String date) {
        if (date == null) {
            date = "";
        }
        dateSelect.sendKeys(date);

    }

    public void setDescriptionSelect(String description) {
        descriptionSelect.sendKeys(description);
    }

    public void clickPayButton() {
        payButton.click();
    }

    public String getMessage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert_content")));
        return messageElements.getText();
    }

    public String getPopUpAlert(String string){
        if (string.equals("Date")){
            return dateSelect.getAttribute("validationMessage");
        }else if (string.equals("Amount")){
            return amountSelect.getAttribute("validationMessage");
        }else {
            return null;
        }
    }


    /**
     * This method returns required field message if required field leaved empty
     */
    public String getRequiredFieldAlert() {
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("alert_content")));
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", driver.findElement(By.name("amount")));
    }

    /**
     * Method for module navigation. Provide tab module to navigate
     * @param subModulePayBills
     *                  Pay Saved Payee
     *                  Add New Payee
     *                  Purchase Foreign Currency
     */
    public void navigateToUnderPayBills(String subModulePayBills){
        WebElement subModuleElement = driver.findElement(By.linkText(subModulePayBills));
            subModuleElement.click();
        }
    }







