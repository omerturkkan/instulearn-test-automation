Feature: User login

  @smoke @ui
  Scenario: Student logs in with valid credentials
    Given the user is on the login page
    When the user logs in with valid student credentials
    Then the user should be logged in
