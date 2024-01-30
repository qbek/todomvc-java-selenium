package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TaskFiltersPO extends PageObject {

    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    public void gotoActiveTasks() {
        WebElement activeTab = getDriver().findElement(activeTabEl);
        activeTab.click();
    }

    public void gotoCompletedTasks() {
        WebElement completedTab = getDriver().findElement(completeTabEl);
        completedTab.click();
    }
}
