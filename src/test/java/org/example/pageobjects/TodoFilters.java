package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class TodoFilters extends PageObject {

    private static final By ACTIVE_FILTER_SELECTOR = cssSelector("[href=\"#/active\"]");
    private static final By COMPLETED_FILTER_SELECTOR = cssSelector("[href=\"#/completed\"]");

    @Step
    public void gotoActive() {
       find(ACTIVE_FILTER_SELECTOR).click();
    }

    @Step
    public void gotoCompleted() {
        find(COMPLETED_FILTER_SELECTOR).click();
    }
}
