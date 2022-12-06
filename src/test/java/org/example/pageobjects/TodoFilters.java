package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class TodoFilters extends PageObject {

    private static final By ACTIVE_FILTER = cssSelector("[href=\"#/active\"]");
    private static final By COMPLETED_FILTER = cssSelector("[href=\"#/completed\"]");

    @Step("Click on #ACTIVE_FILTER")
    public void gotoActive() {
       find(ACTIVE_FILTER).click();
    }

    @Step("Click on #COMPLETED_FILTER")
    public void gotoCompleted() {
        find(COMPLETED_FILTER).click();
    }
}
