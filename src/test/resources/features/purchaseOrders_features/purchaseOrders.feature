@smoketest

Feature: Purchase orders verification


  Scenario: Verify Purchase home page
    Given user logged in and on home page
    Then verify purchase button is present on header menu options



    Scenario: Verify product orders page
     Given user logged in and on home page
      Then purchase order option should be displayed under Purchase
      When click on purchase order
      Then user should be navigated to purchase orders landing page

      Scenario: Verify import button functionality under purchase orders
        Given purchase orders landing page
        Then import button should be displayed
        When click on import button
        Then load file button should be displayed
        When click cancel
        Then user should be navigated to purchase orders landing page