package com.travel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class DashBoard extends BasePage {
    @FindBy(css = "h1.auth-home__masthead__content__largeText")
    WebElement welcomeMsg;

    @FindBy(css = "p.auth-home__masthead__content__smallText")
    WebElement memberIdTxt;

    @FindBy(css = "div.grid-menu__button__contents")
    List<WebElement> tabs;

    public String getUserName() {
        wait.until(visibilityOf(welcomeMsg));
        highlightAndReset(welcomeMsg);
        return welcomeMsg.getText();
    }

    public boolean isTabsOptionsAvailable(String name) {

        wait.until(visibilityOfAllElements(tabs));
        Optional<WebElement> ele = tabs.stream().filter(e -> e.findElement(By.cssSelector("h2")).getText().equalsIgnoreCase(name)).findFirst();
        if (ele.isPresent()) {
            highlightAndReset(ele.get());
            return true;
        } else return false;
    }

    public boolean isMemberIdDisplayed() {
        wait.until(visibilityOf(memberIdTxt));
        return memberIdTxt.isDisplayed();
    }
}
