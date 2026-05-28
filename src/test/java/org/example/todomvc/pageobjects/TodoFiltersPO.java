package org.example.todomvc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TodoFiltersPO {

    private WebDriver browser;
    private final static By ACTIVE_TODOS_FILTER = By.cssSelector("[href=\"#/active\"]");
    private final static By COMPLETED_TODOS_FILTER = By.cssSelector("[href=\"#/completed\"]");

    public TodoFiltersPO(WebDriver browser) {
        this.browser = browser;
    }

    public void gotoActiveTodos() {
        var activeTodosFilter = browser.findElement(ACTIVE_TODOS_FILTER);
        activeTodosFilter.click();
    }

    public void gotoCompletedTodos() {
        var completedTodosFilter = browser.findElement(COMPLETED_TODOS_FILTER);
        completedTodosFilter.click();
    }
}
