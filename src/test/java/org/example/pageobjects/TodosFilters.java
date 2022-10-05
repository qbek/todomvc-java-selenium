package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class TodosFilters extends PageObject {

    private final By ACTIVE_FILTER = By.cssSelector("[href=\"#/active\"");
    private final By COMPLETED_FILTER = By.cssSelector("[href=\"#/completed\"");

    @Step
    public void switchToCompleteTab() {
        find(COMPLETED_FILTER).click();
    }

    @Step
    public void switchToActiveTab() {
        find(ACTIVE_FILTER).click();
    }
}
