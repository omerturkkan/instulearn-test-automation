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
