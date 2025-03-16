package com.travel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProfilePage extends BasePage {

    @FindBy(id = "agentId")
    WebElement agentIdTxt;  
    @FindBy(xpath = "//button[@form='ta-register']")
    WebElement updateInfoBtn;

    @FindBy(css = "div.submit-message")
    WebElement submitMsg;
    public String isTitleAvailable() {
        WebElement ele = driver.findElement(By.tagName("h1"));
        wait.until(visibilityOf(ele));
        highlightAndReset(ele);
        return ele.getText();
    }

    public boolean isPersonalDetailsFieldDisplayedById(String field) {
        WebElement ele = driver.findElement(By.xpath("//h2[contains(.,'I Prefer Profile Information')]/..//label[contains(.,'"+field+"')]/.."));
        scrollToElement(ele);
        highlightAndResetTextField(ele);
        return ele.isDisplayed();
    }

    public boolean isAgencyFieldDisplayedByLabel(String label) {
        WebElement ele = driver.findElement(By.xpath("//h2[contains(.,'Travel Agency Information')]/..//label[contains(.,'"+label+"')]/.."));
        scrollToElement(ele);
        highlightAndResetTextField(ele);
        return ele.isDisplayed();
    }

    public ProfilePage updateAgencyId(String agentId) {
        scrollToElement(agentIdTxt);
        
        agentIdTxt.clear();
        highlightAndFillText(agentIdTxt, agentId);
        return this;
    }
    
    public void saveTAInfo(){
        wait.until(visibilityOf(updateInfoBtn));
        highlightAndClick(updateInfoBtn);
        
    }

    public String getDisplayMsg() {
        wait.until(visibilityOf(submitMsg));
        highlightAndReset(submitMsg);
        return submitMsg.getText();
    }
}
