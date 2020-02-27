@Sezim
Feature: As a user I should be able to create Request For Quotation

  Scenario: User should able to create quotation with filling out dat
  Given Request for quotation page
  When User click create button
  And User filled out mandatory fields
  And User click  save button
    Then User should be able to see Quotation number


    Scenario:  User should not able to create quotation with empty fields
    Given Request for quotation page
    When User click create button
    And User click  save button
    Then It should display error message


      Scenario:  User should be able to use Search button
      Given Request for quotation page
      When User should be able to see search field and search title inside
      And User click and enter valid input
      And User click enter
      Then User should be able to see related result