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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TravelAdvisorStepDef {
    LaunchPage launchPage;
    DashBoard dashBoard;

    @Given("user launch's travel advisor portal")
    public void userLaunchPreferredTravelApplication() {
        launchPage = new LaunchPage();
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
}
