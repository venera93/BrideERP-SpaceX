@smoketest1
  Feature: Incoming Products details feature
    Scenario: User should be able to see details about Incoming Products
      Given User is logged in
      And User is on Incoming Products home page
      When User is clicking on Incoming Products item
      Then User should see details about the product