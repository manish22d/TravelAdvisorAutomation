@TravelAdvisor
Feature: Travel Advisor Portal Dashboard Account Link dropdown


  @DashboardDropdown
  Scenario: Verify account link dropdown is working
    Given user launch's travel advisor portal
    When user hovers over account link dropdown
    Then verify "Profile" option is available
    And verify "My Reservations" option is available
    And verify "Generate Confirmation Letter" option is available
    And verify "Submit Commission Request" option is available
    And verify "Small Social Group Request" option is available
    And verify "My Insights" option is available
    And verify "Contact Us" option is available
    And verify currency dropdown is available
    And verify "Australian Dollar" is available currency dropdown
    And verify "Canadian Dollar" is available currency dropdown
    And verify "Yuan Renminbi" is available currency dropdown
    And verify "Euro" is available currency dropdown
    And verify "Pound Sterling" is available currency dropdown
    And verify "Indian Rupee" is available currency dropdown
    And verify "Singapore Dollar" is available currency dropdown
    And verify "US Dollar" is available currency dropdown
    And verify "Japanese Yen" is available currency dropdown
    And verify "Mexican Peso" is available currency dropdown
    And get screenshot
