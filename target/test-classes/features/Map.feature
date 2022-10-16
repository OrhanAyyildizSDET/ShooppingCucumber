@blue_car_customers_logins
Feature: login_feature
  Scenario Outline: login_with_credentials
    Given user should go to URL "https://www.bluerentalcars.com/"
    When user navigate to login page
    And user enters username "<username>"  and password as "<password>" and click on login button
      |username|<username>|
      |password|<password>|
    Then verify the login is successful
    Then close the application

    Examples: test_data
      |username                    |password  |
      |customer@bluerentalcars.com  |12345     |
      |customer1@bluerentalcars.com |12346     |
      |customer2@bluerentalcars.com |12347     |
      |customer3@bluerentalcars.com |12348     |