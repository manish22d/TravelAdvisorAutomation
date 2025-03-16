package com.travel.stepdef;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.travel.core.WebDriverManager;
import com.travel.pages.DashBoard;
import com.travel.pages.LaunchPage;
import com.travel.pages.ProfilePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class TravelAdvisorStepDef {
    LaunchPage launchPage;
    DashBoard dashBoard;
    ProfilePage profilePage;

    public TravelAdvisorStepDef() {
        launchPage = new LaunchPage();
    }

    @Given("user is logged into the travel advisor portal")
    public void userLaunchPreferredTravelApplication() {
//        launchPage = new LaunchPage();
        dashBoard = launchPage.launchTravelAdvisorPortal().performLogin();
    }

    @When("user name {string} displayed in dashboard")
    public void userNameDisplayedInDashboard(String name) {
        assertEquals(dashBoard.getUserName(), name);
    }

    @Then("verify tab {string} displayed in dashboard")
    public void verifyTabDisplayedInDashboard(String tabName) {
        assertTrue(dashBoard.isTabsOptionsAvailable(tabName));
    }

    @And("get screenshot")
    public void getScreenshot() {
        WebDriver driver = WebDriverManager.getDriver();
        ExtentCucumberAdapter.getCurrentStep()
                .log(Status.INFO, "screenshot",
                        MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
    }

    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {
        launchPage = new LaunchPage();
        launchPage.launchUrl(url);
    }

    @When("I enter {string} in the email field")
    public void iEnterInTheEmailField(String email) {
        launchPage.enterUserName(email);
    }

    @And("I enter {string} in the password field")
    public void iEnterInThePasswordField(String pwd) {
        launchPage.enterPassword(pwd);
    }

    @And("I click the next button")
    public void iClickTheButton() {
        dashBoard = launchPage.clickOnNext();
    }

    @Then("I should be successfully logged in")
    public void iShouldBeSuccessfullyLoggedIn() {
        assertFalse(dashBoard.getUserName().isEmpty());
    }

    @And("I should see the Travel Advisor Portal dashboard")
    public void iShouldSeeTheTravelAdvisorPortalDashboard() {
        assertTrue(dashBoard.isMemberIdDisplayed());
    }

    @When("user hovers over account link dropdown")
    public void userHoversOverAccountLinkDropdown() {
        dashBoard.hoverOverMyAccountLink();
    }

    @Then("verify {string} option is available")
    public void verifyOptionIsAvailable(String option) {
        assertTrue(dashBoard.isDropdownOptionAvailable(option));
    }

    @And("verify currency dropdown is available")
    public void verifyCurrencyDropdownIsAvailable() {
        dashBoard.clickOnCurrencyDropdown();
    }

    @And("verify {string} is available currency dropdown")
    public void verifyIsAvailableCurrencyDropdown(String currency) {
        assertTrue(dashBoard.selectCurrency(currency));
    }

    @When("the user selects to register with an existing I Prefer account")
    public void theUserSelectsToRegisterWithAnExistingIPreferAccount() {
        launchPage.signUpWithExistingAccount();
    }

    @And("the user enters valid I Prefer account credentials")
    public void theUserEntersValidIPreferAccountCredentials() {
        launchPage.enterRegEmailAndPass();
    }


    @Then("the system should check if the account is verified")
    public void theSystemShouldCheckIfTheAccountIsVerified() {
    }

    @And("the system should display a message: {string}")
    public void theSystemShouldDisplayAMessage(String arg0) {
    }

    @And("the user should be unable to proceed with registration")
    public void theUserShouldBeUnableToProceedWithRegistration() {
    }

    @When("the user clicks {string}")
    public void theUserClicks(String arg0) {
    }

    @Then("the system should revalidate the account status")
    public void theSystemShouldRevalidateTheAccountStatus() {
    }

    @And("if the email is still unverified, the same error message should be displayed")
    public void ifTheEmailIsStillUnverifiedTheSameErrorMessageShouldBeDisplayed() {
    }


    @When("user navigates to {string} page")
    public void userNavigatesToPage(String pageName) {
        profilePage = dashBoard.navigateToPage(pageName);
    }

    @And("verify page title is {string}")
    public void verifyPageTitleIs(String title) {
        assertEquals(title, profilePage.isTitleAvailable());
    }

    @Then("verify the personal details fields are displayed")
    public void verifyThePersonalDetailsFieldsAreDisplayed(List<String> fields) {
        for (String field : fields)
            assertTrue(profilePage.isPersonalDetailsFieldDisplayedById(field));

    }

    @Then("verify the travel agency details fields are displayed")
    public void verifyTheTravelAgencyDetailsFieldsAreDisplayed(List<String> fields) {
        for (String field : fields)
            assertTrue(profilePage.isAgencyFieldDisplayedByLabel(field));
    }

    @And("user update {string} into Agency ID field")
    public void userEntersIntoField(String agentId) {
        profilePage.updateAgencyId(agentId).saveTAInfo();
    }

    @Then("message {string} should appear")
    public void messageShouldAppear(String expectedMsg) {
        assertEquals(expectedMsg, profilePage.getDisplayMsg());
    }


}