
@smoketestManager

Feature: User should able to Create Product under Products tab

  Scenario: Create button verification under Products tab
    Given the user is login as a manager
    Then User on Purchases tab
    When User clicks Products tab
    And User should able to see Create Btn

  Scenario: User should able to create new product under Products tab
#    Given User on Products tab under Purchases tab
    When User clicks Create Btn
    And User should able to write new product name inside of  Product Name field
    And User should able to write cost of product inside of Cost field
    Then User clicks save button
    And User should able to see Product Template created message
    And User clicks Edit button


  Scenario:User should not be able to create Products with empty Product Name field under Products tab
    Given User on Products tab
    When User clicks Create Btn
    And User should leave empty Product Name field
    Then User clicks Save Btn
    And user should see warning popup






