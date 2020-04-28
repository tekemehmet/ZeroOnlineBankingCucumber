@login
  Feature: Login

    Only authorized users should be able to login to the application. When user
    logs in with valid credentials, Account summary page should be displayed

  Background: open main page
    Given user is on the login page

    @authorized
  Scenario: Login as authorized user and Account summary page should be displayed
    When user logs in as a authorized user
    Then authorized user should verify that account summary page is displayed

      @non-authorized
      Scenario: User login with wrong username and wrong password should not be able to login
        When user logs in as a  wrong username and wrong password
        Then verify that error message should be displayed




