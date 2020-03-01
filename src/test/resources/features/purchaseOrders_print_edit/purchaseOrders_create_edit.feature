
@smoketest
Feature:Purchase orders tag
Background: Background: User logs in as a user6
  Given User is on Brite ERP page
  When User enters username
  And User enters the password
  And User clicks on the Login button

  Scenario: user should be able to verify edit button
    When  user on purchases page
    And user should able to click purchase orders button
    And user should be  to click to one of orders from list
    And user click edit button
    And user enter Orders on the vendor reference field
    Then  user click save button

    Scenario:user should be able to verify print button
      When user on purchases page
      And user should able to click purchase orders button
      And user should be  to click to one of orders from list
      And user should be able to click print button
      Then user click purchase order from print button option

