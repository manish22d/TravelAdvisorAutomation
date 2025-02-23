package com.travel.core;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public final class WebDriverManager {
	public static final Logger logger = LoggerFactory.getLogger(WebDriverManager.class);
	static WebDriver driver = null;

	public static void initializeWebDriver(){
			System.out.println("initialising Web driver....");
			WebDriverFactory wf= new WebDriverFactory();
			driver = wf.initializeDriver();
			driver.manage().window().maximize();

	}
	public static WebDriver getDriver() {
		if(driver==null) {
			initializeWebDriver();
		}
		return driver;
	}

	public static void shutdownDriver(){
		System.out.println("shutting down Web driver....");
		if(driver!=null) {
			driver.quit();
		}
	}
}
