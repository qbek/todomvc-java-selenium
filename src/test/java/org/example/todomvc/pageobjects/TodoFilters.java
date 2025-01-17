package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TodoFilters extends PageObject {
    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    @Step
   public void goToActiveTab() {
        find(activeTabEl).click();
    }

    @Step
    public void goToCompletedTab() {
        find(completeTabEl).click();
    }
}
