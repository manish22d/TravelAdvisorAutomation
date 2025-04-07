package com.travel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class MakeAReservationPage extends BasePage {

    @FindBy(css = "div.search-desktop input.search-input__input")
    WebElement hotelSearchInputBox;

    @FindBy(css = ".search-desktop__calendar-container button")
    WebElement datePicker;

    @FindBy(css = ".search-desktop__search-btn")
    WebElement searchBtn;
    @FindBy(xpath = "//button[contains(@class ,'rdrDayToday')]/following-sibling::button")
    List<WebElement> activeDates;
    @FindBy(css = "button.calendar-drop__button[variant='primary']")
    WebElement applyBtn;
    @FindBy(css = "div.property-card button[variant='primary']")
    List<WebElement> viewRatesBtn;
    @FindBy(css = "button.RateRow__select-btn")
    List<WebElement> selectRoomBtn;

    public void searchForHotel(String hotelName) {
        highlightAndFillText(hotelSearchInputBox, hotelName);
        highlightAndClick(datePicker);
        highlightAndClick(activeDates.get(10));
        highlightAndClick(activeDates.get(12));
        highlightAndClick(applyBtn);
        highlightAndClick(searchBtn);
        waitForPageToLoad();
        pause(5);
    }

    public BookingPage selectBookingOption() {
        wait.until(visibilityOfAllElements(viewRatesBtn));
        highlightAndClick(viewRatesBtn.get(0));
        pause(3);
        wait.until(visibilityOfAllElements(selectRoomBtn));
        highlightAndClick(selectRoomBtn.get(0));
        waitForPageToLoad();
        pause(3);
        return new BookingPage();
    }
}
