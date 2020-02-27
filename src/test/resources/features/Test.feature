  Feature: Purchases feature

    @smoketest
    Scenario: Reporting tab verification
      Given the user is login as a manager
      When user clicks on Purchase tab
      Then user should see Reporting tab
      And user should taken to the Purchase Analysis page after clicking Reporting tab

    @smoketest
    Scenario: Create button verification under Products tab
      Given the user is login as a manager
      When user clicks on Purchase tab
      Then user should see Products tab
      And user should see create button after clicking Products tab

      @smoketest
      Scenario: User should able to create Products on Products tab
        Given the user is login as a manager
        When user clicks on Purchase tab
        Then user clicks create button
        And  Product Name filed should be field
        And Can be Sold check box should be selected by default
        And Can bePurchased check box should be selected by default
        And Product Type field should be Consumable by default
        And Category field should be All by default
        And Sales Price field should be 1.00 by default
        And Cost field should be 0.00 by default

