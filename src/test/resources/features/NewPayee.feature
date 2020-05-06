@add_new_Payee
Feature: Add new payee under pay bills

  As user, I want to be able to add new payee

  Background: open main page
    Given user is on the login page
    When user logs in as a authorized user

  Scenario: Add a new payee
    And user navigate to "Pay Bills" module
    Then user navigate to PayBill submenu "Add New Payee"

    And creates new payee using following information:
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed

