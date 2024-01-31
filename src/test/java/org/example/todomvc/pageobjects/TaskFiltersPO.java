package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskFiltersPO extends PageObject {

    By completeTabEl = By.cssSelector("[href=\"#/completed\"]");
    By activeTabEl = By.cssSelector("[href=\"#/active\"]");

    public void gotoActiveTasks() {
        find(activeTabEl).click();
    }

    public void gotoCompletedTasks() {
        find(completeTabEl).click();
    }
}
