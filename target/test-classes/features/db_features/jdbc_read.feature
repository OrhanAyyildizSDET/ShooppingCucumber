@db_read
Feature: db_customer_information
  Background:
    Given user connect to the application database
  Scenario: TC01_Get_customer_ssn_info
    And user gets the column "*" from table "tp_customer"
    And user reads all of the column "ssn" data
    Then user close the connection
#    print
  Scenario: TC02_read_customer_phone_info
    And user gets the column "*" from table "tp_customer"
    And user reads all of the column "phone_number" data
    Then user close the connection
  Scenario: TC03_read_customer_firstname_info
    And user gets the column "*" from table "jhi_user"
    And user reads all of the column "first_name" data
    Then user close the connection
#    verify user login
  Scenario: TC04_verify_user_logins
    And user gets the column "*" from table "jhi_user"
    And verify table "jhi_user" and column "login" contains "abidin321"
    Then user close the connection
#    verify if user email contains aby@yahoo.com
  Scenario: TC_05<_Verify_user_email
    And user gets the column "*" from table "jhi_user"
    And verify table "jhi_user" and column "email" contains "aby@yahoo.com"
    Then user close the connection
  Scenario: TC_05_Get_Column_Name
    And user gets the column "*" from table "jhi_user"
    And verify table "jhi_user" and column "balance"
    Then user close the connection