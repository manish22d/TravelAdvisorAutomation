package com.travel.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class WebActions {
    public WebDriver driver;
    public WebDriverWait wait;

    Actions actions;

    public WebActions() {
        this.driver = WebDriverManager.getDriver();
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        actions = new Actions(this.driver);
    }


    public WebElement fluentWait(WebElement element) {
        try {
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(20))
                    .pollingEvery(Duration.ofMillis(5))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotInteractableException.class);
            wait.until(ExpectedConditions.visibilityOf(element));

        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
        }
        return element;
    }

    /**
     * click when ready
     *
     * @param locator locator
     */
    public void clickWhenReady(By locator) {

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public WebElement moveToElement(WebElement ele) {
        actions.moveToElement(ele).build().perform();
        return ele;
    }

    public void moveToElementAndClick(WebElement ele) {
        actions.moveToElement(ele).click().build().perform();
    }

    public void pause(int sec) {
        System.out.printf("paused execution for %d sec %n", sec);
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageToLoad() {
        System.out.println("Waiting for page to load completely " + LocalDateTime.now());
        wait.until((ExpectedCondition) webDriver ->
                ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equalsIgnoreCase("complete")
                        || ((Boolean) ((JavascriptExecutor) webDriver).executeScript("return jQuery.active == 0")));
        System.out.println("Page load completed " + LocalDateTime.now());
    }

    public void fillText(WebElement ele, String txt) {
        String originalStyle = ele.getAttribute("style");
        setAttributeStyle(ele,
                "color: yellow; border: 5px solid blue; background-color: yellow;");
        moveToElement(ele).clear();
        wait.until(visibilityOf(ele));
        pause(1);
        ele.sendKeys(txt);
        setAttributeStyle(ele, originalStyle);
    }

    public void fillTextAndSelectResult(WebElement ele, String txt) {
        fillText(ele, txt);
        List<WebElement> eles = driver.findElements(By.cssSelector("#typeaheadmenu li:first-child a"));
        if (eles.size() > 0)
            eles.get(0).click();
    }

    public void highlightAndClick(WebElement ele) {
        wait.until(elementToBeClickable(ele));
        highlightAndReset(ele);
        ele.click();
    }

    public void highlightAndReset(WebElement ele) {
        String originalStyle = ele.getAttribute("style");
        moveToElement(ele);
        setAttributeStyle(ele,
                "border: 5px solid blue;");
        pause(1);
        setAttributeStyle(ele, originalStyle);
    }

    private void setAttributeStyle(WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', '" + value + "')", element);
    }

    public void highlightAndFillText(WebElement ele, String text) {
        String originalStyle = ele.getAttribute("style");
        setAttributeStyle(ele,
                "color: yellow; border: 5px solid blue; background-color: yellow;");
        moveToElement(ele);
        setAttributeStyle(ele, originalStyle);
        ele.sendKeys(text);
    }

}
