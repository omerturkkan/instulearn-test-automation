@US_002
Feature: Top navbar easy links

  @ui
  Scenario: Visitor sees the easy links on the top navbar
    Given the user is on the home page
    Then the following links should be displayed on the top navbar:
      | Home        |
      | Courses     |
      | Instructors |
      | Store       |
      | Blog        |
