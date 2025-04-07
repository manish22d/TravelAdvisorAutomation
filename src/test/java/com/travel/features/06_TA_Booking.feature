@TravelAdvisor
Feature: Travel Advisor Portal Make A Reservation Page

  @Booking
  Scenario Outline: verify user is able to launch travel advisor dashboard after login
    Given user is logged into the travel advisor portal
    Then User navigates to tab "Make a Reservation"
    And User search for "French Lick Springs Hotel" hotel
    And user selects rate and room for booking
    Then user enters person information
      | firstName   | lastName   | email   | phone   | address1   | countryCode   | state   | city   | zip   |
      | <firstName> | <lastName> | <email> | <phone> | <address1> | <countryCode> | <state> | <city> | <zip> |
#    And user enter agentId as "05657956"
    And user enter payment information
      | number           | name      | userCardExpirationMonth | userCardExpirationYear | cvv |
      | 4111111111111111 | John Test | 01                      | 2027                   | 123 |
    And user accepts terms and click on submit
    Then verify confirmation message "BOOKING SUCCESSFULLY CONFIRMED!" appears

    Examples:
      | firstName | lastName | email              | phone      | address1        | countryCode | state      | city        | zip   |
      | John      | Doe      | john.doe@email.com | 8005551234 | 123 Main Street | US          | California | Los Angeles | 90001 |
