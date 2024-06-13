package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.cssSelector;

public class TodoFilters extends PageObject {

    private By completedFilterEl = cssSelector("[href=\"#/completed\"]");
    private By activeFilterEl = cssSelector("[href=\"#/active\"]");

    @Step
    public void gotoActive() {
        find(activeFilterEl).click();
    }

    @Step
    public void gotoCompleted() {
        find(completedFilterEl).click();
    }
}
