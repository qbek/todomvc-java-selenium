package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoFilters extends PageObject {

    private static final By ACTIVE_TAB_SELECTOR = By.cssSelector("[href=\"#/active\"]");
    private static final By COMPLETED_TAB_SELECTOR = By.cssSelector("[href=\"#/completed\"]");

    public void gotoActive() {
        find(ACTIVE_TAB_SELECTOR).click();
    }

    public void gotoCompleted() {
        find(COMPLETED_TAB_SELECTOR).click();
    }
}
