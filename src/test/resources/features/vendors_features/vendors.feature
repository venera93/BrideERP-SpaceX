Feature: Vendors Features

  @smoketest
  Scenario: Vendor button verification
#    Given the user is login as a user
    When user click on purchase tab
    Then user should see vendors tab
    And user should taken to the Vendors page after clicking Vendors tab

  @smoketest
    Scenario: Create new vendor verification
#    Given the user is login as a user
   When user click on purchase tab
     And user should taken to the Vendors page after clicking Vendors tab
      And user should be able to see the create button and click it
      And user should see individual radio button is selected as a default.
      And user enter a name into name field and click to Save button.
      Then the entered name should display into the next page.

  @smoketest
      Scenario: Search Existing vendors
#       Given the user is login as a user
      When user click on purchase tab
        And user should taken to the Vendors page after clicking Vendors tab
        And User should be able to see the Search field left side of the page
        And user enter a name into the search tab and click
        Then user should see relevant results are displayed.

