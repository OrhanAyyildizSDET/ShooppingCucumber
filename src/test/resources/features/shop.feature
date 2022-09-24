@shopping_test
Feature: Automation Exercise

  Scenario Outline: Shopping_Scenario
    Given user should go to URL "http://automationexercise.com"
    Then verify that you are in home page
    When click on sign up button
    And  Enter name and email and click on SignUp Button
    And Fill all details in Signup and create account
    Then Verify ACCOUNT CREATED! and click Continue button
    And Verify  Logged in as username at top
    When Add products to cart
    And Click Cart button
    Then Verify that cart page is displayed
    When Click Proceed To Checkout
    Then Verify that the delivery address and billing address are same
    When Click logout button
    Then Verify that user logged out
    And Close the application

#    Examples:
#      | name | email               |
#      | John | john12@yahoo.com    |
#      | John | john12@yahoo.com.uk |


