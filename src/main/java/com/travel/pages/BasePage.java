package com.travel.pages;


import com.travel.core.WebActions;
import com.travel.core.WebDriverManager;
import com.travel.utils.PropertyUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

@Slf4j
public class BasePage extends WebActions {

    public WebDriver driver;
    public WebDriverWait wait;
    public Properties property;
    Actions actions;

    public BasePage() {
        this.driver = WebDriverManager.getDriver();
        property = PropertyUtils.getProperty();
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        actions = new Actions(this.driver);
        PageFactory.initElements(this.driver, this);
    }
}
