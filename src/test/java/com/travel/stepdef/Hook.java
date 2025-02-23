package com.travel.stepdef;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.travel.core.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hook {
    @Before
    public void setup(){
        WebDriverManager.initializeWebDriver();
    }
    @After
    public void teardown(Scenario scenario) {
        System.out.println("this is After");
        if (scenario.isFailed()) {
            WebDriver driver = WebDriverManager.getDriver();
            ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
        }
        WebDriverManager.shutdownDriver();
    }
}
