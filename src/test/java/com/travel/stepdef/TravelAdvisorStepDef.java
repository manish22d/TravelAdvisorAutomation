package com.travel.stepdef;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.travel.core.WebDriverManager;
import com.travel.pages.DashBoard;
import com.travel.pages.LaunchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class TravelAdvisorStepDef {
    LaunchPage launchPage;
    DashBoard dashBoard;

    public TravelAdvisorStepDef() {
        launchPage = new LaunchPage();
    }

    @Given("user launch's travel advisor portal")
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
}
