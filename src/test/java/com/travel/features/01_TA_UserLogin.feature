@TravelAdvisor
Feature: User Login Functionality

@userLogin
  Scenario: Verify user can log in with valid credentials
    Given I navigate to "https://ta.preferredhotels.com"
    When I enter "adubovik@preferredtravelgroup.com" in the email field
    And I enter "Anypassword123!" in the password field
    And I click the next button
    Then I should be successfully logged in
    And I should see the Travel Advisor Portal dashboard