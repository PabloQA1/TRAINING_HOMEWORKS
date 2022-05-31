@smoke
Feature: Search product

  Scenario: As a user, I wants to search products on the ebay.com
    Given I opened ebay home page
    When I search the product "Dell optiplex core i3"
    Then The item "Dell Optiplex Core i3" should be the first in the Search Result grid

    Scenario Outline: As a user, I wants to search products on the ebay.com
      Given I opened ebay home page
      When I search the product "<request>"
      Then The item "<request>" should be the first in the Search Result grid

      Examples:
        | request |
        | Nike air max 90  |
        | Adidas ultra boost  |