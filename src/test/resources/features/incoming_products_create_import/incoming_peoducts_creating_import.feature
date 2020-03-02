@smoketest
Feature: As a user I should be able to add a single "Incoming Product" into the "Incoming Products" list

  Background:
    Given User is on purchase Module
    And User is on Incoming products tab

#    Then User is on create page in Incoming Products

  Scenario: By creating: user should be able to import "incoming product" documents from existing resources
    When user clicks on Create button from Incoming Products
    When User fills all required fields
    When User saves changes
    Then User sees the new created file

  Scenario: By creating(Negative): user should be able to import "incoming product" documents from existing resources
    When user clicks on Create button from Incoming Products
    When User saves changes
    Then User sees pupUp warning

  Scenario: By importing: user should be able to create new "Incoming product" by creating in "Incoming Product" tab

    When user clicks on Import button from Incoming Products
    Then User is on Import page in Incoming Products


