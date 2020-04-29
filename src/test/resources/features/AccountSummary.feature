@account_Summary
Feature: Account Summary

  Account summary page should have the title Zero – Account summary. Account
  summary page should have to following account types: Cash Accounts, Investment
  Accounts, Credit Accounts, Loan Accounts. Credit Accounts table must have columns
  Account, Credit Card and Balance.

  Background: open main page
    Given user is on the login page
    When user logs in as a authorized user

  @title_verify
  Scenario: Account summary page should have the title Zero – Account summary.
    Then Verify that Account summary page title "Zero - Account Summary"



    @verify_header
    Scenario: Account summary page should have to following account types: Cash Accounts, Investment
    Accounts, Credit Accounts, Loan Accounts.

      And Verify that Account summary should have as follows:
      |Cash Accounts|
      |Investment Accounts|
      |Credit Accounts    |
      |Loan Accounts      |



 @table_header_verify
  Scenario: Credit Accounts table must have columns, Account, Credit Card and Balance.
    Then Verify that Credit Accounts table should have as follows:
   |Account|
   |Credit Card|
   |Balance    |