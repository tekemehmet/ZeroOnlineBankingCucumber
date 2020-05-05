@PayBills
Feature: Pay Bills

  As user, I want to be able to use Pay Bills functionality

  #Account Activity page should have the title Zero – Pay Bills. When user completes a
  #successful Pay operation, The payment was successfully submitted. should be
  #displayed. When user tries to make a payment without entering the amount or date,
  #Please fill out this field message! should be displayed.
  #Amount field should not accept alphabetical or special characters. Date field should
  #not accept alphabetical characters.
  #NOTE: For the date input field, you can just use sendKeys. No need to click on the date navigator.

  Background: open main page
    Given user is on the login page
    When user logs in as a authorized user
    Then user navigate to "Pay Bills" module


  @PayBills_Title
  Scenario: Pay Bills page should have the title Zero – Pay Bills.

    Then Verify that Pay Bills page title "Zero - Pay Bills"


  @PayBills_Payee
  Scenario: user completes a successful Pay operation

    And user creates a payment with following info:
      | Payee           | Account   | Amount | Date       | Description  |
      | Apple           | Loan      | 1000   | 2020-05-01 | Pay for Loan |
      | Sprint          | Brokerage | 5000   | 2020-06-05 | Payment      |
      | Bank of America | Cheking   | 100    | 2020-07-05 | Pay          |



    Then user click on Pay button
    Then Verify that "The payment was successfully submitted." message





