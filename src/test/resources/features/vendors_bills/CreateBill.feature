Feature: User can create new vendor bill

  @smoketest @rita
  Scenario:
    Given User is in Vendor Bill main page
    Then User click on create bill button
    Then User press vendor dropdown field
    Then User click Search more
    And  User entering vendor name in search field
    Then User click on right vendor
    Then User click save button
    Then User can observe new bill is created


    @smoketest @rita
    Scenario:
      Given User is in Vendor Bill main page
      Then User click on create bill button
      Then User click save button
      Then User can see error message







