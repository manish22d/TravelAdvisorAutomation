package com.travel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

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
    @FindBy(xpath = "//div[@class='HeaderLink__flex']/div/a/div")
    List<WebElement> dropdownOptions;

    @FindBy(css = "div.currency-select3 option")
    List<WebElement> currencyOptions;
    @FindBy(xpath = "//div[@class='currency-select3']/select")
    WebElement currencyDropdown;
    @FindBy(css = "span.HeaderLink__text p")
    WebElement myAccountLink;

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
        highlightAndReset(memberIdTxt);
        return memberIdTxt.isDisplayed();
    }

    public void hoverOverMyAccountLink() {
        highlightAndReset(myAccountLink);
        moveToElement(myAccountLink);
    }

    public boolean isDropdownOptionAvailable(String dropdownOption) {
        wait.until(visibilityOfAllElements(dropdownOptions));
        Optional<WebElement> ele = dropdownOptions.stream().filter(e -> e.getText().equalsIgnoreCase(dropdownOption)).findFirst();
        if (ele.isPresent()) {
            highlightAndReset(ele.get());
            return true;
        } else return false;
    }

    public void clickOnCurrencyDropdown() {
        moveToElementAndClick(currencyDropdown);
    }

    public boolean selectCurrency(String currency) {

        if(currencyOptions.get(0).isDisplayed())
            clickOnCurrencyDropdown();
        Select select = new Select(currencyDropdown);
        System.out.println(select.getAllSelectedOptions().get(0).getText());
        select.selectByVisibleText(currency);
        System.out.println(select.getAllSelectedOptions().get(0).getText());
        highlightAndReset(currencyDropdown);
//        System.out.println(currencyDropdown.getText());
//        System.out.println(currencyOptions.get(0).isDisplayed());
//        Optional<WebElement> ele = currencyOptions.stream().filter(e -> e.getText().equalsIgnoreCase(currency)).findFirst();
//        if (ele.isPresent()) {
//            highlightAndReset(ele.get());
//            return true;
//        } else return false;
        return true;
    }
}
