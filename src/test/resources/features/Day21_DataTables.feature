@data_tables
Feature: data_tables
  Scenario: customer_login
    Given user should go to URL "https://www.bluerentalcars.com/"
    When user navigate to login page
    And user enters manager_username and manager_password
    |username                     |password  |
    |customer@bluerentalcars.com  |12345     |
    Then verify the login is successful
    And capture the screenshot
    Then close the application



