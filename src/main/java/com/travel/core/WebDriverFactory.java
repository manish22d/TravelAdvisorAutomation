package com.travel.core;


import com.travel.listeners.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebDriverFactory {
	static WebDriver driver = null;



	protected WebDriver initializeDriver() {
//		DriverType browser = DriverType.valueOf(System.getProperty("browser").toUpperCase());
		DriverType browser = DriverType.valueOf("chrome".toUpperCase());
		switch (browser) {
			case FIREFOX :
				driver = getFirefoxDriver();
				break;
			case CHROME :
				driver = getChromeDriver();
				break;
			case EDGE :
				driver = getEdgeDriver();
				break;
		}
		WebEventListener listener = new WebEventListener();//Create instance of Listener Class
		EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(listener); //Pass listener to constructor

		driver = decorator.decorate(driver);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		return driver;
	}

	private WebDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	private WebDriver getChromeDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setCapability("unhandledPromptBehavior", "accept");
		chromeOptions.setExperimentalOption("useAutomationExtension", false);
		chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		chromeOptions.addArguments("--disable-notifications");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		chromeOptions.setExperimentalOption("prefs", prefs);
		WebDriverManager.chromedriver().cachePath("driver").clearResolutionCache().setup();

		return new ChromeDriver(chromeOptions);
	}

	private WebDriver getInternetExplorerDriver() {
		WebDriverManager.iedriver().setup();
		return new InternetExplorerDriver();
	}

	private WebDriver getEdgeDriver() {
		WebDriverManager.edgedriver().cachePath("driver").setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--start-maximized");
		options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
		options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		return new EdgeDriver(options);
	}
}
