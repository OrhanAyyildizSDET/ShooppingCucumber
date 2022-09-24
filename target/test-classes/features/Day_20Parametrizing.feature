@parameterized01
Feature: Google_Search
  Background: User_goes_to_google
    Given user should go to URL "https://google.com"
    Scenario: TC01_mercedes
      Given user search for "mercedes" on the google
      Then verify that page title contains "mercedes"
      Then close the application
  Scenario: TC02_Games
    Given user search for "pc games" on the google
    Then verify that page title contains "pc games"
    Then close the application
  

#  we use "" to send dynamic data for feature file
#  We parameterizing like this
#  There are other ways : Scenario Outline,DataTables