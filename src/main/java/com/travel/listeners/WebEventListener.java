package com.travel.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.time.Duration;
import java.util.Arrays;


public class WebEventListener implements WebDriverListener {

	@Override
	public void beforeGet (WebDriver driver, String url) {

		//System.out.println ("Navigating to : "+url);
		System.out.println("Navigating to : " + url);
	}

	@Override
	public void afterGet (WebDriver driver, String url) {
		System.out.println("Navigated to : " + url);
	}
	@Override
	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
//		System.out.println("Element found : "+locator.toString());
	}
	@Override
	public void afterClick(WebElement element) {
		System.out.println("clicked on: "+element);
	}

	@Override
	public void beforePageLoadTimeout (WebDriver.Timeouts timeouts, Duration duration) {
		//System.out.println ("Pageload timeout countdown begins!");
		System.out.println("Pageload timeout countdown begins!");
	}


	@Override
	public void afterSendKeys (WebElement element, CharSequence... keysToSend) {
		System.out.println ("Keys to send : "+ Arrays.toString(keysToSend) + " on element :"+element);
	}

}
