package com.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class BookingPage extends BasePage {
    @FindBy(id = "firstName")
    WebElement firstName;
    @FindBy(id = "lastName")
    WebElement lastName;
    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "phone")
    WebElement phone;
    @FindBy(id = "address1")
    WebElement address1;
    @FindBy(id = "countryCode")
    WebElement countryCode;
    @FindBy(id = "state")
    WebElement state;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "zip")
    WebElement zip;
    @FindBy(id = "agentId")
    WebElement agentId;
    @FindBy(id = "number")
    WebElement number;
    @FindBy(id = "name")
    WebElement name;
    @FindBy(id = "userCardExpirationMonth")
    WebElement userCardExpirationMonth;
    @FindBy(id = "userCardExpirationYear")
    WebElement userCardExpirationYear;
    @FindBy(id = "csv")
    WebElement cvv;
    @FindBy(id = "agreeConditions")
    WebElement agreeConditions;
    @FindBy(id = "agreePrivacy")
    WebElement agreePrivacy;
    @FindBy(id = "agentNotes")
    WebElement agentNotes;
    @FindBy(css = "button.bookingForm__submit-btn")
    WebElement completeBookingBtn;
    @FindBy(css = "#confirmation-greeting h2.ConfirmationSection__header")
    WebElement successMsg;
    @FindBy(xpath = "//section[@id='confirmation-redirects']/button[contains(.,'Continue')]")
    WebElement continueBtn;

    public void enterPersonalDetails(Map<String, String> personalDetails) {
        highlightAndFillText(firstName, personalDetails.get("firstName"));
        highlightAndFillText(lastName, personalDetails.get("lastName"));
        highlightAndFillText(email, personalDetails.get("email"));
        highlightAndFillText(phone, personalDetails.get("phone"));
        highlightAndFillText(address1, personalDetails.get("address1"));
        selectFromDropdown(countryCode, personalDetails.get("countryCode"));
        highlightAndFillText(state, personalDetails.get("state"));
        highlightAndFillText(city, personalDetails.get("city"));
        highlightAndFillText(zip, personalDetails.get("zip"));
    }

    public BookingPage enterAgentId(String agentIdTxt) {
        highlightAndFillText(agentId, agentIdTxt);
        return this;
    }

    public BookingPage enterPaymentInfo(Map<String, String> paymentInfo) {
        highlightAndFillText(number, paymentInfo.get("number"));
        highlightAndFillText(name, paymentInfo.get("name"));
        selectFromDropdown(userCardExpirationMonth, paymentInfo.get("userCardExpirationMonth"));
        selectFromDropdown(userCardExpirationYear, paymentInfo.get("userCardExpirationYear"));
        highlightAndFillText(cvv, paymentInfo.get("cvv"));
        return this;
    }

    public BookingPage enterMsgToClient(String msg) {
        scrollToElement(agentNotes);
        highlightAndFillText(agentNotes, msg);
        return this;
    }

    public BookingPage agreeToTerms() {
        highlightAndClick(agreeConditions);
        highlightAndClick(agreePrivacy);
        return this;
    }

    public void submit() {
        highlightAndClick(completeBookingBtn);

        pause(5);
    }

    public String getSuccessMsg() {
        fluentWait(successMsg);
        highlightAndReset(successMsg);
        return successMsg.getText();
    }


}
