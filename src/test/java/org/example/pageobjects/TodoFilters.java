package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TodoFilters extends PageObject {
    By completeTab = By.cssSelector("[href=\"#/completed\"]");
    By activeTab = By.cssSelector("[href=\"#/active\"]");

    @Step
    public void switchToActive() {
        find(activeTab).click();
    }

    @Step
    public void switchToCompleted() {
        find(completeTab).click();
    }
}
