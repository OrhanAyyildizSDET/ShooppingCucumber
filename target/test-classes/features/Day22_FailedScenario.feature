@failed_scenario
Feature: failed_test_cases

  Scenario: TC_01
    Given user should go to URL "https://www.google.com/"
    And user search for "iphone" on the google
    Then verify test case fails