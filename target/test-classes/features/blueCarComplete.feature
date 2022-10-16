Feature: FE3425_Reservation_Feature
  Background: User Logins the Application
    Given  user should go to URL "https://www.bluerentalcars.com/"
    When user navigate to login page
    And user enters manager_username and manager_password
      |username                     |password  |
      |customer@bluerentalcars.com  |12345     |
    Then verify the login is successful
    Then capture the screenshot
  @BlueCar_reservation_Creation
  Scenario: TC01_Reservation_Creation
    Given user is on the home page
    And select a car model "Opel Insigna"
    And enter pick up field
    And enter drop off field
    And select pick up date
    And select drop off date
    And click continue reservation
    And verify complete reservation screen pops up
    And enter card number
    And enter name on the card
    And enter expire date and CVC
    And checks the agreement
    And click complete reservation
    Then verify "Reservation created successfully" pop up
    Then close the application