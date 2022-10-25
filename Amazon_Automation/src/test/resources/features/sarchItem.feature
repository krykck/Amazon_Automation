@searchItem @regression
Feature: Search

  Scenario: Search item
    Given I am on the amazon.com
    When I search "laptop"
    And I select Apple brand
    And I select the highest customer reviews
    And I enter min price: "500"
    And I enter max price: "2000"
    And I click on Go button
    And I sort by Price: Low to High
    And I select the first available product
    And I add the product to the shopping cart
    Then I should see the product added to the shopping cart