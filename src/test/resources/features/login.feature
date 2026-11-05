@US_001
Feature: User login

  @smoke @ui
  Scenario: Student logs in with valid credentials
    Given the user is on the login page
    When the user logs in with valid "student" credentials
    Then the user should be logged in

  @ui
  Scenario: Teacher logs in with valid credentials
    Given the user is on the login page
    When the user logs in with valid "teacher" credentials
    Then the user should be logged in

  @ui
  Scenario: Student cannot log in with an invalid password
    Given the user is on the login page
    When the user logs in as "student" with password "WrongPassword123"
    Then the error message "The password or username is incorrect." should be displayed
    And the user should stay on the login page

  @ui
  Scenario: Login page displays the login form elements
    Given the user is on the login page
    Then the login image should be displayed
    And the heading "Log in to your account" should be displayed
    And the email and password fields should be enabled
    And the login button should be enabled

  @ui
  Scenario: User navigates from the login page to the register page
    Given the user is on the login page
    When the user clicks the signup link
    Then the user should be on the register page

  @ui
  Scenario: User navigates from the login page to the forgot password page
    Given the user is on the login page
    When the user clicks the forgot password link
    Then the forgot password page should open in a new tab

  @ui
  Scenario: User navigates from the home page to the login page
    Given the user is on the home page
    When the user clicks the login link in the top bar
    Then the user should be on the login page
