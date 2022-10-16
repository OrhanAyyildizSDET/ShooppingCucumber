Feature: test_api reqistrant info
  @tokenApi
  @getApiRegistrants
  Scenario: test_api_registrant
    Given user sends get request for users data
    And user deserialization the users data to java
    Then user saves users data correspondent files to validate