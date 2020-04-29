@Account_Activity
Feature: Account Activity

  As user, I want to be able to use Accout Activity

  #Account Activity page should have the title Zero – Account activity.
  #In the Account drop down default option should be Savings. Account drop down
  #should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
  #Transactions table should have column names Date, Description, Deposit,
  #Withdrawal

  Background: open main page
    Given user is on the login page
    When user logs in as a authorized user
    Then user navigate to "Account Activity" module

  @account_Activity_Title
  Scenario: Account Activity page should have the title Zero – Account activity.
    Then Verify that Account Activity page title "Zero - Account Activity"

  @account_Activity_defaultSaving
  Scenario: In the Account drop down default option should be Savings
    Then Verify that Account drop down default is "Savings"

  @account_Activity_dropdown
  Scenario: Account drop down should have the following options: Savings, Checking, Loan, Credit Card, Brokerage.
    Then Verify that drop down should have following options:
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  @account_Activity_tableHeader
  Scenario: Transactions table should have column names Date, Description, Deposit, Withdrawal
    Then Verify that transactions table should have following options
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |
