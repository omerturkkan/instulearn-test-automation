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

  @ui
  Scenario Outline: Visitor is redirected to the relevant page from the top navbar
    Given the user is on the home page
    When the user clicks the "<link>" link on the top navbar
    Then the page URL should contain "<path>"

    Examples:
      | link        | path         |
      | Courses     | /classes     |
      | Instructors | /instructors |
      | Store       | /products    |
      | Blog        | /blog        |

  @ui
  Scenario: Site logo leads to the home page
    Given the user is on the home page
    And the user clicks the "Courses" link on the top navbar
    When the user clicks the site logo
    Then the user should be on the home page

  @ui
  Scenario: Logged-in user sees the cart and notifications buttons
    Given the user is on the login page
    And the user logs in with valid "student" credentials
    And the user is on the home page
    Then the cart button should be visible
    And the notifications button should be visible and enabled

  @ui
  Scenario: Visitor searches from the top navbar
    Given the user is on the home page
    When the user searches for "java" on the top navbar
    Then the page URL should contain "/search?search=java"

  @ui
  Scenario: Visitor is redirected to the login page from Start learning
    Given the user is on the home page
    When the user clicks the Start learning button on the top navbar
    Then the user should be on the login page

  @ui
  Scenario: Visitor is redirected to the register page from the top bar
    Given the user is on the home page
    When the user clicks the register link in the top bar
    Then the user should be on the register page
