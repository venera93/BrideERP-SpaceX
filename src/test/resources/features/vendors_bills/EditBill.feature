Feature: User can be able to edit vendor bill

  @smoketest @rita
  Scenario:
    Given User is in Vendor Bill main page
    Then  User pic first bill in list
    And   User click bill edit button
    Then  User click add new item in a bill
    Then  User click on add item dropdown
    And   User choosing search more items
    Then  User entering item for search and press enter
    Then  User click on right item
    Then  User click save button
    Then  User can observe new item inside the bill






