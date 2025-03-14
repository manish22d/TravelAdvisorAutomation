@TravelAdvisor
Feature: User Registration Functionality

  @InvaliduserLogin
  Scenario: Verify user get error while registering with registered email id
    Given I navigate to "https://ta.preferredhotels.com"
    When the user selects to register with an existing I Prefer account
    And the user enters valid I Prefer account credentials
    Then the system should check if the account is verified
    And the system should display a message: "This I Prefer account is locked until email address is validated."
    And the user should be unable to proceed with registration
    When the user clicks "Check again"
    Then the system should revalidate the account status
    And if the email is still unverified, the same error message should be displayed