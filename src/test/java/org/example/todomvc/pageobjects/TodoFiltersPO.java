package org.example.todomvc.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TodoFiltersPO extends PageObject {


    private final static By ACTIVE_TODOS_FILTER = By.cssSelector("[href=\"#/active\"]");
    private final static By COMPLETED_TODOS_FILTER = By.cssSelector("[href=\"#/completed\"]");


    public void gotoActiveTodos() {
        var activeTodosFilter = getDriver().findElement(ACTIVE_TODOS_FILTER);
        activeTodosFilter.click();
    }

    public void gotoCompletedTodos() {
        var completedTodosFilter = getDriver().findElement(COMPLETED_TODOS_FILTER);
        completedTodosFilter.click();
    }
}
