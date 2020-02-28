Feature: Products tag

  Background: User logs in as a user6
    Given User is on Brite ERP page
    When User enters username
    And User enters the password
    And User clicks on the Login button

  @smoketest
  Scenario: User should be able to click on Products
    When User clicks on the purchases module
    And User clicks on the Products tag
    When User should be able to see the title Products - Odoo

  @smoketest
  Scenario: User should be able to search for an item
    When User clicks on the purchases module
    And User clicks on the Products tag
    And User enters "laptop" on the search box
    And  User clicks on search products for
    Then User clicks on the cross button
    And User enters the "tiktik"
    And  User clicks on search products for
    Then User sees a message

  @smoketest
  Scenario: User should be able to see the details of the product
    When User clicks on the purchases module
    And User clicks on the Products tag
    When User clicks the product from the list
    Then User is navigated to the product description page
    And User clicks on the each tab




