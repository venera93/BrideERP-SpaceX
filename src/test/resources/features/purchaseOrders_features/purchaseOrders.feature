Feature: Purchase orders verification

  Scenario: Verify Purchase home page
    Given user logged in and on home page
    Then verify purchase button is present on header menu options

    Scenario:
      Given user logged in and on home page
      Then purchase order option should be displayed under Purchase
      When click on purchase order
      Then user should be navigated to purchase orders landing page