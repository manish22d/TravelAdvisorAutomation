@TravelAdvisor
Feature: Travel Advisor Portal Dashboard


  @Dashboard
  Scenario: verify user is able to launch travel advisor dashboard after login
    Given user launch's travel advisor portal
    When user name "Welcome, Alex Dubovik !" displayed in dashboard
    Then verify tab "Make a Reservation" displayed in dashboard
    Then verify tab "Travel Advisor Rates" displayed in dashboard
    Then verify tab "My Reservations" displayed in dashboard
    Then verify tab "View Offers" displayed in dashboard
    Then verify tab "About Us" displayed in dashboard
    Then verify tab "Resources" displayed in dashboard
    And get screenshot