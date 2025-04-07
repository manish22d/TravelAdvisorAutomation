@TravelAdvisor
Feature: Travel Advisor Profile page

  @ProfilePage
  Scenario: Verify all fields are present and update Travel Agency ID
    Given user is logged into the travel advisor portal
    When user navigates to "Profile" page
    And verify page title is "My Account"
    Then verify the personal details fields are displayed
      | First       |
      | Last        |
      | Email       |
      | Address     |
      | Country     |
      | City        |
      | State       |
      | Postal Code |
    Then verify the travel agency details fields are displayed
      | Travel Agency Name         |
      | Travel Agency Address      |
      | City                       |
      | Country                    |
      | State                      |
      | Zip Code                   |
      | Your Business Phone Number |
      | IATA/Travel Agency ID      |
      | Luxury Travel Affiliation  |
    And user update "05657956" into Agency ID field
    Then message "Travel Agency information saved successfully." should appear
    And get screenshot
