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
