Feature: User can be able to search for specific bill

  @smoketest @rita
  Scenario:
    Given User is in Vendor Bill main page
    Then  User entering bill name inside Search field
    Then  Correct bill should be present and user click on it
    Then  Bill page info is opened
