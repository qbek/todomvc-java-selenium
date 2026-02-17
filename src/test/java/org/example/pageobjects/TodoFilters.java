package org.example.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoFilters {

    private static final By ACTIVE_TAB_SELECTOR = By.cssSelector("[href=\"#/active\"]");
    private static final By COMPLETED_TAB_SELECTOR = By.cssSelector("[href=\"#/completed\"]");

    private WebDriver browser;

    public TodoFilters(WebDriver browser) {
        this.browser = browser;
    }

    public void gotoActive() {
        var el = browser.findElement(ACTIVE_TAB_SELECTOR);
        el.click();
    }

    public void gotoCompleted() {
        var el = browser.findElement(COMPLETED_TAB_SELECTOR);
        el.click();
    }
}
