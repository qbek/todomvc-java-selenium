package org.example.todomvc.pageobjects;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TodoFiltersPO extends PageObject {


    private final static By ACTIVE_TODOS_FILTER = By.cssSelector("[href=\"#/active\"]");
    private final static By COMPLETED_TODOS_FILTER = By.cssSelector("[href=\"#/completed\"]");

    @Step
    public void gotoActiveTodos() {
        find(ACTIVE_TODOS_FILTER).click();
    }

    @Step
    public void gotoCompletedTodos() {
        find(COMPLETED_TODOS_FILTER).click();
    }
}
