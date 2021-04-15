@run @flight-search
 Feature: search Flights and select from results list

  Scenario: search Flights for return trip
    Given user navigates to expedia site and selects flights option
    And enters leavingFrom "Sydney" and GoingTo "Melbourne"
    And selects departing and returning dates
    Then clicks on search button
    Then selects departure and return flights from results list