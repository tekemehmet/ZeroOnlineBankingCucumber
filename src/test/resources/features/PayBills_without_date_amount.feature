@PayBills_2
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


  @PayBills_Title_2
  Scenario: Pay Bills page should have the title Zero – Pay Bills.

    Then Verify that Pay Bills page title "Zero - Pay Bills"


  @PayBills_Payee_without_date_amount
  Scenario Outline: user completes a unsuccessful Pay operation

    And user creates a payment with following info:
      | Payee   | Account   | Amount   | Date   | Description   |
      | <payee> | <account> | <amount> | <date> | <description> |

    Then user click on Pay button
    Then Verify that error message "Please fill out this field." message

    Examples:

      | payee           | account     | amount | date       | description  |
      | Sprint          | Savings     |        | 2020-05-10 | Test payment |
      | Sprint          | Credit Card | 1000   |            | Test payment |
      | Sprint          | Brokerage   |        | 2020-05-10 | Test payment |
      | Bank of America | Savings     | 1000   |            | Test payment |
      | Bank of America | Credit Card |        | 2020-05-10 | Test payment |
      | Bank of America | Brokerage   | 1000   |            | Test payment |
      | Apple           | Savings     |        | 2020-05-10 | Test payment |
      | Apple           | Checking    | 1000   |            | Test payment |
      | Apple           | Brokerage   |        | 2020-05-10 | Test payment |
      | Wells Fargo     | Savings     | 1000   |            | Test payment |
      | Wells Fargo     | Checking    |        | 2020-05-10 | Test payment |
      | Wells Fargo     | Loan        | 1000   |            | Test payment |




