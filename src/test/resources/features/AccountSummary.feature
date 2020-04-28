@account-summary
Feature: Account Summary

  Account summary page should have the title Zero – Account summary. Account
  summary page should have to following account types: Cash Accounts, Investment
  Accounts, Credit Accounts, Loan Accounts. Credit Accounts table must have columns
  Account, Credit Card and Balance.

  @title-verify
  Scenario: Account summary page should have the title Zero – Account summary.
    Then Verify that Account summary page title "Zero-Account Summary"


    @verify-header
    Scenario: Account summary page should have to following account types: Cash Accounts, Investment
    Accounts, Credit Accounts, Loan Accounts.

      Then Verify that Account summary has "Cash Accounts","Investment Accounts","Credit Accounts" and "Loan Accounts"


 @table-header-verify
  Scenario: Credit Accounts table must have columns, Account, Credit Card and Balance.
    Then Verify that Credit Accounts table have "Account" , "Credit" and "Balance"