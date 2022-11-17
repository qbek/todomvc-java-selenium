package org.example.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TodoFilters extends PageObject {
    By completeTabSelector = By.cssSelector("[href=\"#/completed\"]");
    By activeTabSelector = By.cssSelector("[href=\"#/active\"]");

    @Step
    public void switchToActive() {
        WebElement activeTab = getDriver().findElement(activeTabSelector);
        activeTab.click();
    }

    @Step
    public void switchToCompleted() {
        WebElement completeTab = getDriver().findElement(completeTabSelector);
        completeTab.click();
    }
}
