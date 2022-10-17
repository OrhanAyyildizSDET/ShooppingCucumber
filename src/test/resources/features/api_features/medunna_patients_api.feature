Feature: medunna_patients_api
  @tokenApi
  @allPatients
  Scenario: patients
    Given admin send the request for patients data
    And admin deserialization the patients data to java
    Then admin saves patients data correspondent files to validate