package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class Filters extends PageObject {

    private final By activeFilterElement = By.cssSelector(".filters [href=\"#/active\"]");
    private final By completedFilterElement = By.cssSelector(".filters [href=\"#/completed\"]");

    @Step
    public void switchToActive() {
        find(activeFilterElement).click();
    }

    @Step
    public void switchToCompleted() {
        find(completedFilterElement).click();
    }
}
