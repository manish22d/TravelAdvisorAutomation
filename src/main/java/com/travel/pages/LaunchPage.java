package com.travel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LaunchPage extends BasePage {

    @FindBy(css = "div.login input[id=':r0:']")
    WebElement emailTxtBox;

    @FindBy(css = "div.login input[id=':r1:']")
    WebElement pwdTxtBox;

    @FindBy(css = "button.login__submit")
    WebElement nextBtn;

    @FindBy(css = "span.HeaderLink__text p")
    WebElement myAccountLink;

    @FindBy(css = "span.HeaderLink__text p")
    WebElement acceptCookieBtn;

    @FindBy(css = "button.top-info__close")
    List<WebElement> closeInfoBtn;

    public LaunchPage launchTravelAdvisorPortal() {
        driver.navigate().to(property.getProperty("app.ta.url"));
        waitForPageToLoad();
        pause(3);
        WebElement acceptBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        wait.until(visibilityOf(acceptBtn));
        highlightAndClick(acceptBtn);
        if (closeInfoBtn.size() > 0) {
            highlightAndClick(closeInfoBtn.get(0));
        }

        return this;
    }

    public DashBoard performLogin() {
        String user = property.getProperty("app.ta.email");
        String cred = property.getProperty("app.ta.cred");
        fillText(emailTxtBox, user);
        fillText(pwdTxtBox, cred);
        highlightAndClick(nextBtn);
        wait.until(visibilityOf(myAccountLink));
        return new DashBoard();
    }

    public LaunchPage launchUrl(String url) {
        driver.navigate().to(url);
        waitForPageToLoad();
        pause(3);
        WebElement acceptBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        wait.until(visibilityOf(acceptBtn));
        highlightAndClick(acceptBtn);
        return this;
    }

    public LaunchPage enterUserName(String username) {
        fillText(emailTxtBox, username);
        return this;
    }

    public LaunchPage enterPassword(String password) {
        fillText(pwdTxtBox, password);
        return this;
    }

    public DashBoard clickOnNext() {
        highlightAndClick(nextBtn);
        wait.until(visibilityOf(myAccountLink));
        return new DashBoard();
    }

}
