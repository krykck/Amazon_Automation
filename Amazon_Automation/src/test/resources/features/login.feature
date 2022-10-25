@login @regression
Feature: Login

  Scenario: Unsuccessful login
    Given I access amazon.com
    When I click on Sign-in button
    And I enter random input "dgdgd" for email
    And I click on continue button
    Then I should see warning message


  Scenario Outline: Validate unsuccessful login with different data
    Given I access amazon.com
    When I click on Sign-in button
    And I enter random input <email> for email
    And I click on continue button
    Then I should see warning message

    Examples:
      | email           | warningMessage                                    |
      | adasda@test.com | We cannot find an account with that email address |
