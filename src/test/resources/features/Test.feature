
@smoketest


  Feature: Purchases feature

    Scenario: Reporting tab verification
      Given the user is login as a manager
      When user clicks on Purchase tab
      Then user should see Reporting tab
      And user should taken to the Purchase Analysis page after clicking Reporting tab


