@smoke
Feature: Cart checking

  Scenario: As a user, I wants to purchase product
    Given I opened ebay home page
    When I search the product "casio g shock frogman"
    And The item "casio g shock frogman" should be the first in the Search Result grid
    And I click to first product on the page
    And I click to the add product to the card button and cart page is opening
    Then The item "casio g shock frogman" should be in the cart
