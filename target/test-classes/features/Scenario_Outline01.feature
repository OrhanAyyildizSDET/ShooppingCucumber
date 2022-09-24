@scenario_outline01
Feature: Scenario_outline

  Background: User_goes_to_google
    Given user should go to URL "https://google.com"

  Scenario Outline: Google_Search

    Given user search for "<item>" on the google
    Then verify that page title contains "<item>"
    Then close the application


    Examples: test_data
      |item|
      |mercedes|
      |tesla |
      |toyota  |
      |honda   |
      |bmw     |