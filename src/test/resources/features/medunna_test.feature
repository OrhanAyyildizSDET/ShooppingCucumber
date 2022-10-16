Feature: Medunna_test
  Background:
    Given user should go to URL "https://www.medunna.com/"
    Then capture the screenshot
  @Medunna_test
  Scenario Outline: Medunna room manipulation
  Given Sign in as Admin with "<username>" and "<password>"
  When Click on Items&Titles button
  And Click on Room button
  And Click on Create a new Room button
  Then Verify Create or edit a Room text
  When Enter the room number in the room number box
  And Clear the room number
  And Click on Room Type dropdown
  Then Verify This field is required.
  When Enter the room number as "<room number>" in the room number box
  Then Verify 5 room types exist in Room Type dropdown
  When Click on Status Checkbox
  Then Verify that checkbox is selected
  When Send price as "<price>" to price box
  And Clear the price box
  And Click on Description box
  Then Verify This field is required.
  When Send price to price box
  And Send description as "<description>" to the Description box
  And Clear the Description box
  And Click on price
  Then Verify that This field is required is not displayed
  When Click on first view button with room number "<room number>"
  Then Verify Room header "<room number>"
  When Click on back button
  Then Verify there are 20 view buttons
  When Click on Edit Button
  And Change the Description
  And Click on save button
  Then Verify The room is updated.
  When Click on Created Date to sort rooms from newest to oldest
  And Click on first delete button
  And Click on Delete button on alert
  Then Verify A room is Deleted message
  And Close the application
    Examples:
      | username | password | room number | price | description |
      | adminrecep    |123Recep  |12110    |123    |for flue     |

