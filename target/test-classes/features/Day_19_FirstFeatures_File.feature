Feature: Search Feature
  Background: User_goes_to_google
    Given user should go to the google page

  @iphone
  Scenario:TC01_iphone_search
    And user search for iPhone
    When do iphone 13 search
    Then user should see results
    Then close the window

  @TeaPot
  Scenario: TC02_Teapot_Search
    When do teapot search
    Then verify the title contains the Teapot
    Then close the window

  @BlueRentalCars
  Scenario: TC03_BlueRental_Login
    Given user go to the blue rental car site
    When user click the login button
    And user enters true credential
    And user click the login button again
    Then verify user is in user page
    Then close the window