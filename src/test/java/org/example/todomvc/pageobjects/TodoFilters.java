package org.example.todomvc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoFilters {
    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    WebDriver browser;

    public TodoFilters (WebDriver browser) {
        this.browser = browser;
    }

    public void goToActiveTab() {
        var activeFilter = browser.findElement(activeTabEl);
        activeFilter.click();
    }

    public void goToCompletedTab() {
        var completedFilter = browser.findElement(completeTabEl);
        completedFilter.click();
    }
}
