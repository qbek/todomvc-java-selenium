package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class TodoFilters {

    private static final By ACTIVE_FILTER_SELECTOR = cssSelector("[href=\"#/active\"]");
    private static final By COMPLETED_FILTER_SELECTOR = cssSelector("[href=\"#/completed\"]");

    private WebDriver browser;

    public TodoFilters (WebDriver browser) {
        this.browser = browser;
    }

    public void gotoActive() {
        var activeFilter = browser.findElement(ACTIVE_FILTER_SELECTOR);
        activeFilter.click();
    }

    public void gotoCompleted() {
        var completedFilter = browser.findElement(COMPLETED_FILTER_SELECTOR);
        completedFilter.click();
    }
}
