
@run @hotels-search
Feature: search hotels and select from results list

  Scenario: search hotels for one room two travellers
    Given user navigates to expedia site and selects hotels option
    And enters destination as "sydney"
    And selects checkin and checkout dates
    Then clicks on search button
    Then selects first option from results list