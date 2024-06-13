package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class TodoFilters extends PageObject {

    private By completedFilterEl = cssSelector("[href=\"#/completed\"]");
    private By activeFilterEl = cssSelector("[href=\"#/active\"]");

    public void gotoActive() {
        var activeFilter = getDriver().findElement(activeFilterEl);
        activeFilter.click();
    }

    public void gotoCompleted() {
        var completedFilter = getDriver().findElement(completedFilterEl);
        completedFilter.click();
    }
}
