package com.github.qbek.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationBar extends PageObject {

    By completedTabSelector = By.cssSelector(".filters [href=\"#/completed\"]");
    By activeTabSelector = By.cssSelector(".filters [href=\"#/active\"]");

    public void goToActiveTodos() {
        WebDriver browser = getDriver();
        WebElement active = browser.findElement(activeTabSelector);
        active.click();
    }

    public void goToCompletedTodos() {
        WebDriver browser = getDriver();
        WebElement completed = browser.findElement(completedTabSelector);
        completed.click();
    }


}
