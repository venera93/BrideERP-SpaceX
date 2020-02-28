@smoketest
Feature: Incoming Products Search Function

  Scenario Outline: User should be able to search for Incoming Products Positive Search Verification
    Given User is on Incoming Products home page
    When User is searching for an "<item>"
    Then User should see only searched "<items>"

    Examples: User fills out the form as followed from the table below:
      | item      | items     |
      | ice cream | ice cream |
